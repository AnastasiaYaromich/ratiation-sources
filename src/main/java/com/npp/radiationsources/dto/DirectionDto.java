package com.npp.radiationsources.dto;

import java.util.List;

public class DepartmentDirectionDto {
    private String name;
    private List<RadiationSourceDto> sources;

    public DepartmentDirectionDto() {}

    public DepartmentDirectionDto(String name, List<RadiationSourceDto> sources) {
        this.name = name;
        this.sources = sources;
    }
}
