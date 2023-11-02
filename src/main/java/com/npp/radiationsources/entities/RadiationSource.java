package com.npp.radiationsources.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "radiation_sources", schema = "radiation")
public class RadiationSource {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "activity")
    private Double activity;

    @Column(name = "half_life")
    private Double halfLife;

    @Column(name = "manufacture_at")
    private LocalDateTime manufactureDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "direction_id", nullable = false)
    private Direction direction;
}
