package com.kyro.projectmanagement.services;

import com.kyro.projectmanagement.dto.UserDto;
import com.kyro.projectmanagement.model.User;
import org.springframework.stereotype.Service;

public interface UserService {

    UserDto findById(Long id);
}
