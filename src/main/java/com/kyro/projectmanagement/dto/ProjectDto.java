package com.kyro.projectmanagement.dto;

import com.kyro.projectmanagement.model.Project;
import com.kyro.projectmanagement.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectDto {

    private Long id;
    private String name;
    private User projectOwner;
    private long projectHours;
    private List<TaskDto> subTasks;

    public ProjectDto() {
    }

    public ProjectDto(Long id, String name, User projectOwner, long projectHours, List<TaskDto> subTasks) {
        this.id = id;
        this.name = name;
        this.projectOwner = projectOwner;
        this.projectHours = projectHours;
        this.subTasks = subTasks;
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

    public User getProjectOwner() {
        return projectOwner;
    }

    public void setProjectOwner(User projectOwner) {
        this.projectOwner = projectOwner;
    }

    public long getProjectHours() {
        return projectHours;
    }

    public void setProjectHours(long projectHours) {
        this.projectHours = projectHours;
    }

    public List<TaskDto> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<TaskDto> subTasks) {
        this.subTasks = subTasks;
    }

    public static ProjectDto convertTODTO(Project project) {
        if (project == null) {
            return null;
        }

        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(project.getId());
        projectDto.setName(project.getName());
        projectDto.setProjectOwner(project.getProjectOwner());
        projectDto.setProjectHours(project.getProjectHours());
        if (project.getSubTasks() != null) {
            projectDto.setSubTasks(project.getSubTasks().stream().map(taskEnt -> TaskDto.convertToDTO(taskEnt)).collect(Collectors.toList()));
        }
        return projectDto;
    }
}
