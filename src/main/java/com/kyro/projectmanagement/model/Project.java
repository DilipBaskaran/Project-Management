package com.kyro.projectmanagement.model;

import java.util.List;


public class Project {
    private Long id;
    private String name;
    private User projectOwner;
    private long projectHours;
    private List<Task> subTasks;

    public Project() {
    }

    public Project(Long id, String name, User projectOwner, long projectHours, List<Task> subTasks) {
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

    public List<Task> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<Task> subTasks) {
        this.subTasks = subTasks;
    }
}
