package com.npp.radiationsources.mappers;

import com.npp.radiationsources.dto.RadiationSourceDto;
import com.npp.radiationsources.entities.RadiationSource;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import java.util.Optional;

@Mapper
public interface RadiationSourceMapper {
    RadiationSourceMapper MAPPER = Mappers.getMapper(RadiationSourceMapper.class);

    RadiationSource sourceDtoToSource(RadiationSourceDto r);
    RadiationSourceDto sourceToSourceDto(RadiationSource r);

    @AfterMapping
    default void setRadiationSource(@MappingTarget RadiationSource radiationSource) {
        Optional.ofNullable(radiationSource.getDirection())
                .ifPresent(direction -> direction.getSources().add(radiationSource));
    }
}

