package com.npp.radiationsources.controllers;

import com.npp.radiationsources.dto.DepartmentDto;
import com.npp.radiationsources.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public List<DepartmentDto> getAllDepartments() {
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public DepartmentDto getDepartmentById(@PathVariable Long id) throws Exception {
        return departmentService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addDepartment(@RequestBody DepartmentDto departmentDto) {
        departmentService.save(departmentDto);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartmentById(@PathVariable Long id) {
        departmentService.deleteById(id);
    }
}
