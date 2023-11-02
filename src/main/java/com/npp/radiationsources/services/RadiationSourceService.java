package com.npp.radiationsources.services;

import com.npp.radiationsources.dto.RadiationSourceDto;
import com.npp.radiationsources.entities.RadiationSource;
import com.npp.radiationsources.mappers.RadiationSourceMapper;
import com.npp.radiationsources.repositories.RadiationSourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RadiationSourceService {
    private final RadiationSourceRepository radiationSourceRepository;

    public List<RadiationSourceDto> findAll() {
        List<RadiationSource> sources = radiationSourceRepository.findAll();
        return sources.stream().map(RadiationSourceMapper.MAPPER::sourceToSourceDto).collect(Collectors.toList());
    }

    public RadiationSourceDto findByType(String type) throws Exception {
        Optional<RadiationSource> source = radiationSourceRepository.findByType(type);
        if(source.isPresent()) {
            return RadiationSourceMapper.MAPPER.sourceToSourceDto(source.get());
        }
        throw new Exception();
    }

    public RadiationSourceDto findById(Long id) throws Exception {
        Optional<RadiationSource> source = radiationSourceRepository.findById(id);
        if(source.isPresent()) {
            return RadiationSourceMapper.MAPPER.sourceToSourceDto(source.get());
        }
        throw new Exception();
    }

    public void deleteById(Long id) {
        radiationSourceRepository.deleteById(id);
    }

    public void save(RadiationSourceDto sourceDto) {
        RadiationSource source = RadiationSourceMapper.MAPPER.sourceDtoToSource(sourceDto);
        radiationSourceRepository.save(source);
    }
}
