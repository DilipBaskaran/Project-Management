package com.kyro.projectmanagement.services;

import com.kyro.projectmanagement.dto.ProjectDto;
import com.kyro.projectmanagement.model.Project;
import org.springframework.stereotype.Service;

@Service
public interface ProjectService {
    ProjectDto findById(Long id);
    ProjectDto findByProjectName(String name);
}
