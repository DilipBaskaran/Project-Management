package com.kyro.projectmanagement.dto;

import com.kyro.projectmanagement.model.Resource;
import com.kyro.projectmanagement.model.Task;
import com.kyro.projectmanagement.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class TaskDto {
    private Long id;
    private String name;
    private double completionHours;
    private List<ResourceDto> dependencyResources;
    private List<TaskDto> dependencyTasks;
    private UserDto taskOwner;

    public TaskDto() {
    }

    public TaskDto(Long id, String name, double completionHours, List<ResourceDto> dependencyResources, List<TaskDto> dependencyTasks, UserDto taskOwner) {
        this.id = id;
        this.name = name;
        this.completionHours = completionHours;
        this.dependencyResources = dependencyResources;
        this.dependencyTasks = dependencyTasks;
        this.taskOwner = taskOwner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCompletionHours() {
        return completionHours;
    }

    public void setCompletionHours(double completionHours) {
        this.completionHours = completionHours;
    }

    public List<ResourceDto> getDependencyResources() {
        return dependencyResources;
    }

    public void setDependencyResources(List<ResourceDto> dependencyResources) {
        this.dependencyResources = dependencyResources;
    }

    public List<TaskDto> getDependencyTasks() {
        return dependencyTasks;
    }

    public void setDependencyTasks(List<TaskDto> dependencyTasks) {
        this.dependencyTasks = dependencyTasks;
    }

    public UserDto getTaskOwner() {
        return taskOwner;
    }

    public void setTaskOwner(UserDto taskOwner) {
        this.taskOwner = taskOwner;
    }

    public static TaskDto convertToDTO(Task task) {
        if (task == null) {
            return null;
        }

        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setName(task.getName());
        taskDto.setTaskOwner(UserDto.convertToDTO(task.getTaskOwner()));
        taskDto.setCompletionHours(task.getCompletionHours());
        if (task.getDependencyTasks() != null) {
            taskDto.setDependencyTasks(task.getDependencyTasks().stream().map(taskEnt -> TaskDto.convertToDTO(taskEnt)).collect(Collectors.toList()));
        }
        if (task.getDependencyResources() != null) {
            taskDto.setDependencyResources(task.getDependencyResources().stream().map(resourceEnt -> ResourceDto.convertToDTO(resourceEnt)).collect(Collectors.toList()));
        }

        return taskDto;
    }
}
