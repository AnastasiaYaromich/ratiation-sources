package com.npp.radiationsources.mappers;

import com.npp.radiationsources.dto.DirectionDto;
import com.npp.radiationsources.dto.RadiationSourceDto;
import com.npp.radiationsources.entities.Direction;
import com.npp.radiationsources.entities.RadiationSource;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper
public interface DirectionMapper {
    DirectionMapper MAPPER = Mappers.getMapper(DirectionMapper.class);

    @Mapping(target = "sources", qualifiedByName = "sourceListDtoToSourceList")
    Direction directionDtoToDirection(DirectionDto d);

    @IterableMapping(qualifiedByName = "sourceDtoToSource")
    @Named("sourceListDtoToSourceList")
    List<RadiationSource> sourceListDtoToSourceList(List<RadiationSourceDto> r);

    @Named("sourceDtoToSource")
    RadiationSource sourceDtoToSource(RadiationSourceDto r);

    @Mapping(target = "sources", qualifiedByName = "sourcesListToSourcesListDto")
    DirectionDto directionToDirectionDto(Direction d);

    @IterableMapping(qualifiedByName = "sourceToSourceDto")
    @Named("sourcesListToSourcesListDto")
    List<RadiationSourceDto> sourcesListToSourcesListDto(List<RadiationSource> r);

    @Named("sourceToSourceDto")
    RadiationSourceDto sourceToSourceDto(RadiationSource r);

    @AfterMapping
    default void setDirection(@MappingTarget Direction direction) {
        Optional.ofNullable(direction.getDepartment())
                .ifPresent(department -> department.getDirections().add(direction));

        Optional.ofNullable(direction.getSources())
                .ifPresent(sources -> sources.forEach(s -> s.setDirection(direction)));
    }
}
