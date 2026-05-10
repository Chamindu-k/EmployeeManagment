package com.chamindu.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Author by chamindu_kaushalya
 */


@Entity
@Table(name="furniture_type")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FurnitureType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String furnitureName;
    private String furnitureType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "furniture_id", nullable = false)
    private Furniture furniture;
}