package com.npp.radiationsources.mappers;

import com.npp.radiationsources.dto.RadiationSourceDto;
import com.npp.radiationsources.entities.RadiationSource;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RadiationSourceMappers {
        RadiationSourceMappers MAPPER = Mappers.getMapper(RadiationSourceMappers.class);
        RadiationSourceDto mapRadiationSourceToDto(RadiationSource r);
        RadiationSource mapDtoToRadiationSource(RadiationSourceDto r);
}

