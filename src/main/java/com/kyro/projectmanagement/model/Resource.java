package com.kyro.projectmanagement.model;

public class Resource {
    private Long id;
    private ResourceType resourceType;
    private User lockedBy;

    public Resource() {
    }

    public Resource(Long id, ResourceType resourceType, User lockedBy) {
        this.id = id;
        this.resourceType = resourceType;
        this.lockedBy = lockedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public User getLockedBy() {
        return lockedBy;
    }

    public void setLockedBy(User lockedBy) {
        this.lockedBy = lockedBy;
    }
}

