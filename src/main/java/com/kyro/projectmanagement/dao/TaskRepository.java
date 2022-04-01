package com.kyro.projectmanagement.dao;

import com.kyro.projectmanagement.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
