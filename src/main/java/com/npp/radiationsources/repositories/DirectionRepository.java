package com.npp.radiationsources.repositories;

import com.npp.radiationsources.entities.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DirectionRepository extends JpaRepository<Direction, Long> {
    Optional<Direction> findByName(String name);
}
