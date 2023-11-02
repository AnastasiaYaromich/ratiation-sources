package com.npp.radiationsources.controllers;

import com.npp.radiationsources.dto.DirectionDto;
import com.npp.radiationsources.services.DirectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/directions")
public class DirectionController {
    private final DirectionService directionService;

    @GetMapping
    public List<DirectionDto> getAllDirections() {
        return directionService.findAll();
    }

    @GetMapping("/{id}")
    public DirectionDto getDirectionById(@PathVariable Long id) throws Exception {
        return directionService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addDirection(@RequestBody DirectionDto directionDto) {
        directionService.save(directionDto);
    }

    @DeleteMapping("/{id}")
    public void deleteDirectionById(@PathVariable Long id) {
        directionService.deleteById(id);
    }
}
