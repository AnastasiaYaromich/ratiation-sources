package com.npp.radiationsources.repositories;

import com.npp.radiationsources.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findById(Long id);
    Optional<Department> findByName(String name);
    List<Department> findAll();
}
