package com.npp.radiationsources.dto;

import com.npp.radiationsources.entities.Direction;
import lombok.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RadiationSourceDto {
    private Long id;
    private String type;
    private Double activity;
    private Double halfLife;
    private LocalDateTime manufactureDate;
    private DirectionDto direction;
}
