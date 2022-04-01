package com.kyro.projectmanagement.services;

import com.kyro.projectmanagement.dao.ResourceRepository;
import com.kyro.projectmanagement.dto.ResourceDto;
import com.kyro.projectmanagement.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl implements ResourceService{

    @Autowired
    ResourceRepository resourceRepository;

    @Override
    public ResourceDto findById(Long id) {
        return null;
    }
}
