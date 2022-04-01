package com.kyro.projectmanagement.services;

import com.kyro.projectmanagement.dto.TaskDto;

public interface TaskService {
    TaskDto findById(Long id);
}
