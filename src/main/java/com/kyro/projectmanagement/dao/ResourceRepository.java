package com.kyro.projectmanagement.dao;

import com.kyro.projectmanagement.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
