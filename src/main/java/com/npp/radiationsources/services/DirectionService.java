package com.npp.radiationsources.services;

import com.npp.radiationsources.repositories.DirectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentDirectionService {
    private final DirectionRepository departmentDirectionRepository;
}
