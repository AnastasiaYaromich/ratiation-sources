package com.npp.radiationsources.services;

import com.npp.radiationsources.dto.DepartmentDto;
import com.npp.radiationsources.entities.Department;
import com.npp.radiationsources.exceptions.ResourceNotFoundException;
import com.npp.radiationsources.mappers.DepartmentMapper;
import com.npp.radiationsources.repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<DepartmentDto> findAll() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map(DepartmentMapper.MAPPER::departmentToDepartmentDto).collect(Collectors.toList());
    }

    public DepartmentDto findByName(String name) throws Exception {
        Optional<Department> department = departmentRepository.findByName(name);
        if(department.isPresent()) {
            return DepartmentMapper.MAPPER.departmentToDepartmentDto(department.get());
        }
        throw new ResourceNotFoundException("Структурное подразделение " + name + " не найдено");
    }

    public DepartmentDto findById(Long id) throws Exception {
        Optional<Department> department = departmentRepository.findById(id);
        if(department.isPresent()) {
            DepartmentDto departmentDto = DepartmentMapper.MAPPER.departmentToDepartmentDto(department.get());
        }
        throw new ResourceNotFoundException("Структурное подразделение " + id + " не найдено");
    }

    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }

    public void save(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.MAPPER.departmentDtoToDepartment(departmentDto);
        departmentRepository.save(department);
    }
}
