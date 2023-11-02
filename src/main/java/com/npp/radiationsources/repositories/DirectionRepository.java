package com.npp.radiationsources.repositories;

import com.npp.radiationsources.entities.DepartmentDirection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DepartmentDirectionRepository extends JpaRepository<DepartmentDirection, Long> {
    Optional<DepartmentDirection> findByName(String name);
}
