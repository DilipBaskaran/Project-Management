package com.kyro.projectmanagement.dto;

import com.kyro.projectmanagement.model.Resource;
import com.kyro.projectmanagement.model.ResourceType;

public class ResourceDto {
    private Long id;
    private ResourceType resourceType;
    private UserDto lockedBy;

    public ResourceDto() {
    }

    public ResourceDto(Long id, ResourceType resourceType, UserDto lockedBy) {
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

    public UserDto getLockedBy() {
        return lockedBy;
    }

    public void setLockedBy(UserDto lockedBy) {
        this.lockedBy = lockedBy;
    }

    public static ResourceDto convertToDTO(Resource resource) {
        if (resource == null) {
            return null;
        }

        ResourceDto resourceDto = new ResourceDto();
        resourceDto.setId(resource.getId());
        resourceDto.setResourceType(resource.getResourceType());
        resourceDto.setLockedBy(UserDto.convertToDTO(resource.getLockedBy()));
        return resourceDto;
    }
}
