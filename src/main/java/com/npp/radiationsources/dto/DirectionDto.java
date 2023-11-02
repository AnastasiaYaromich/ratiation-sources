package com.npp.radiationsources.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DirectionDto {
    private Long id;
    private String name;
    private DepartmentDto department;
    private List<RadiationSourceDto> sources;
}
