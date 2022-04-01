package com.kyro.projectmanagement.model;

import java.math.BigDecimal;
import java.util.List;

public class Task {
    private Long id;
    private String name;
    private double completionHours;
    private List<Resource> dependencyResources;
    private List<Task> dependencyTasks;
    private User taskOwner;

    public Task() {
    }

    public Task(Long id, String name, double completionHours, List<Resource> dependencyResources, List<Task> dependencyTasks, User taskOwner) {
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

    public List<Resource> getDependencyResources() {
        return dependencyResources;
    }

    public void setDependencyResources(List<Resource> dependencyResources) {
        this.dependencyResources = dependencyResources;
    }

    public List<Task> getDependencyTasks() {
        return dependencyTasks;
    }

    public void setDependencyTasks(List<Task> dependencyTasks) {
        this.dependencyTasks = dependencyTasks;
    }

    public User getTaskOwner() {
        return taskOwner;
    }

    public void setTaskOwner(User taskOwner) {
        this.taskOwner = taskOwner;
    }
}
