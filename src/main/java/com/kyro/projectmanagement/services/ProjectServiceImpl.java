package com.kyro.projectmanagement.services;

import com.kyro.projectmanagement.dao.ProjectRepository;
import com.kyro.projectmanagement.dto.ProjectDto;
import com.kyro.projectmanagement.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public ProjectDto findById(Long id) {
        return ProjectDto.convertTODTO(projectRepository.findById(id).orElse(null));
    }

    @Override
    public ProjectDto findByProjectName(String name) {
        List<Project> projectList = projectRepository.findByName(name);
        if (CollectionUtils.isEmpty(projectList)) {
            return null;
        }
        return ProjectDto.convertTODTO(projectList.get(0));
    }
}
