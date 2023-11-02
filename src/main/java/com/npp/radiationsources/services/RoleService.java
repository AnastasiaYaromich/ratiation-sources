package com.npp.radiationsources.services;

import com.npp.radiationsources.entities.Role;
import com.npp.radiationsources.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role findByName(String name) {
        return roleRepository.findByName(name).get();
    }
}
