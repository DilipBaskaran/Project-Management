package com.kyro.projectmanagement;

import com.kyro.projectmanagement.dao.ProjectRepository;
import com.kyro.projectmanagement.dto.ProjectDto;
import com.kyro.projectmanagement.dto.ResourceDto;
import com.kyro.projectmanagement.dto.TaskDto;
import com.kyro.projectmanagement.services.ProjectService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.CollectionUtils;

import java.util.List;

@SpringBootApplication
public class ProjectManagementApplication {

    @Autowired
    static ProjectService projectService;

    public static void main(String[] args) {
        SpringApplication.run(ProjectManagementApplication.class, args);

        ProjectDto projectDto = projectService.findByProjectName("Project 1");


        System.out.println("Project with Name \"Project 1\" "
                + (willProjectComplete(projectDto)?"will":"will not")
                + " complete on time.");

    }

    private static boolean willProjectComplete(ProjectDto projectDto) {

        if (projectDto == null || CollectionUtils.isEmpty(projectDto.getSubTasks())) {
           return true;
        }

        return willprojectTasksComplete(projectDto.getSubTasks(), projectDto.getProjectHours());
    }

    private static boolean willprojectTasksComplete(List<TaskDto> taskDtos, long projectHours) {
        if (taskDtos == null ) {
            return true;
        }

        if (projectHours < 0l) {

        }

        Double projectHoursTaken = 0d;
        for (TaskDto taskDto : taskDtos) {
            Pair<Boolean, Double> taskCompletion = checkTaskCompletion(taskDto);
            if (Boolean.TRUE.equals(taskCompletion.getKey())) {
                projectHoursTaken += taskCompletion.getValue();
            } else {
                return false;
            }
        }

        if(projectHoursTaken > Double.valueOf(projectHours)) {
            return false;
        }
        return true;
    }

    private static Pair<Boolean, Double> checkTaskCompletion(TaskDto taskDto) {

        Double taskCompletionHours = 0d;

        List<TaskDto> dependencyTasks = taskDto.getDependencyTasks();
        if (!CollectionUtils.isEmpty(dependencyTasks)) {
            for (TaskDto dependencyTask : dependencyTasks) {
                Pair<Boolean, Double> taskCompletion = checkTaskCompletion(dependencyTask);
                if (Boolean.TRUE.equals(taskCompletion.getKey())) {
                    taskCompletionHours += taskCompletion.getValue();
                } else {
                    return new Pair<>(Boolean.FALSE, null);
                }
            }
        }
        List<ResourceDto> dependencyResources = taskDto.getDependencyResources();
        if (!CollectionUtils.isEmpty(dependencyResources)) {
            for (ResourceDto dependencyResource : dependencyResources) {
                if (dependencyResource.getLockedBy() == null
                        || dependencyResource.getLockedBy().equals(taskDto.getTaskOwner())){
                    continue;
                } else {
                    // Need to wait for the resource usage, if waiting period gets extended which means extra hours and considering it as deviation from the time
                    // It can be implemented with the lock mechanism to find out how much deviation will happen to project completion.
                    new Pair<>(Boolean.FALSE, null);
                }
            }
        }
        taskCompletionHours += taskDto.getCompletionHours();

        return new Pair<>(Boolean.TRUE,taskCompletionHours);
    }


}
