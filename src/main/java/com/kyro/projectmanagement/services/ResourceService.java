package com.kyro.projectmanagement.services;

import com.kyro.projectmanagement.dto.ResourceDto;

public interface ResourceService {
    ResourceDto findById(Long id);
}
