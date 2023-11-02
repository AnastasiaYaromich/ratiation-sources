package com.npp.radiationsources.repositories;

import com.npp.radiationsources.entities.RadiationSource;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface RadiationSourceRepository extends JpaRepository<RadiationSource, Long> {
    List<RadiationSource> findAll();
    Optional<RadiationSource> findByType(String type);
}
