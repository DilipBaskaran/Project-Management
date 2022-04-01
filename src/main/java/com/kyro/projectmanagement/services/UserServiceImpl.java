package com.kyro.projectmanagement.services;

import com.kyro.projectmanagement.dao.UserRepository;
import com.kyro.projectmanagement.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto findById(Long id) {
        return UserDto.convertToDTO(userRepository.findById(id).orElse(null));
    }
}
