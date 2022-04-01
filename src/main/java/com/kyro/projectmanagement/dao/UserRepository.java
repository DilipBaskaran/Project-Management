package com.kyro.projectmanagement.dao;

import com.kyro.projectmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
