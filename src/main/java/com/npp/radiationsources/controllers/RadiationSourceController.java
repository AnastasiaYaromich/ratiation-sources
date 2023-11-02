package com.npp.radiationsources.controllers;

import com.npp.radiationsources.dto.RadiationSourceDto;
import com.npp.radiationsources.services.RadiationSourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sources")
public class RadiationSourceController {
    private final RadiationSourceService radiationSourceService;

    @GetMapping
    public List<RadiationSourceDto> getAllSources() {
        return radiationSourceService.findAll();
    }

    @GetMapping("/{id}")
    public RadiationSourceDto getSourceById(@PathVariable Long id) throws Exception {
        return radiationSourceService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addSource(@RequestBody RadiationSourceDto sourceDto) {
        radiationSourceService.save(sourceDto);
    }

    @DeleteMapping("/{id}")
    public void deleteDirectionById(@PathVariable Long id) {
        radiationSourceService.deleteById(id);
    }
}
