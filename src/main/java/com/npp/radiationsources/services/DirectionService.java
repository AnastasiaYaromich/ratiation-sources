package com.npp.radiationsources.services;

import com.npp.radiationsources.dto.DirectionDto;
import com.npp.radiationsources.entities.Direction;
import com.npp.radiationsources.mappers.DirectionMapper;
import com.npp.radiationsources.repositories.DirectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DirectionService {
    private final DirectionRepository directionRepository;

    public List<DirectionDto> findAll() {
        List<Direction> directions = directionRepository.findAll();
        return directions.stream().map(DirectionMapper.MAPPER::directionToDirectionDto).collect(Collectors.toList());
    }

    public DirectionDto findByName(String name) throws Exception {
        Optional<Direction> direction = directionRepository.findByName(name);
        if(direction.isPresent()) {
            return DirectionMapper.MAPPER.directionToDirectionDto(direction.get());
        }
        throw new Exception();
    }

    public DirectionDto findById(Long id) throws Exception {
        Optional<Direction> direction = directionRepository.findById(id);
        if(direction.isPresent()) {
            return DirectionMapper.MAPPER.directionToDirectionDto(direction.get());
        }
        throw new Exception();
    }

    public void deleteById(Long id) {
        directionRepository.deleteById(id);
    }

    public void save(DirectionDto directionDto) {
        Direction direction = DirectionMapper.MAPPER.directionDtoToDirection(directionDto);
        directionRepository.save(direction);
    }
}
