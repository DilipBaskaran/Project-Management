package com.kyro.projectmanagement.services;

import com.kyro.projectmanagement.dao.TaskRepository;
import com.kyro.projectmanagement.dto.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    TaskRepository taskRepository;

    @Override
    public TaskDto findById(Long id) {
        return TaskDto.convertToDTO(taskRepository.findById(id).orElse(null));
    }
}
