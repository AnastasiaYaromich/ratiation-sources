package com.npp.radiationsources.mappers;

import com.npp.radiationsources.dto.DepartmentDto;
import com.npp.radiationsources.dto.DirectionDto;
import com.npp.radiationsources.entities.Department;
import com.npp.radiationsources.entities.Direction;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import java.util.List;
import java.util.Optional;

@Mapper
public interface DepartmentMapper {
    DepartmentMapper MAPPER = Mappers.getMapper(DepartmentMapper.class);

    @Mapping(target = "directions", qualifiedByName = "directionListDtoToDirectionList")
    Department departmentDtoToDepartment(DepartmentDto d);

    @IterableMapping(qualifiedByName = "directionDtoToDirection")
    @Named("directionListDtoToDirectionList")
    List<Direction> directionListDtoToDirectionList(List<DirectionDto> d);

    @Named("directionDtoToDirection")
    Direction directionDtoToDirection(DirectionDto d);

    @Mapping(target = "directions", qualifiedByName = "directionListToDirectionListDto")
    DepartmentDto departmentToDepartmentDto(Department d);

    @IterableMapping(qualifiedByName = "directionToDirectionDto")
    @Named("directionListToDirectionListDto")
    List<DirectionDto> directionListToDirectionListDto(List<Direction> d);

    @Named("directionToDirectionDto")
    DirectionDto directionToDirectionDto(Direction d);

    @AfterMapping
    default void setDepartment(@MappingTarget Department department) {
        Optional.ofNullable(department.getDirections())
                .ifPresent(d -> d.forEach(direction -> direction.setDepartment(department)));
    }
}
