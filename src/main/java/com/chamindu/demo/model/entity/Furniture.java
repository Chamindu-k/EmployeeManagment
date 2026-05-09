package com.chamindu.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Author by chamindu_kaushalya
 */
@Entity
@Table(name="furniture")
@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Furniture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String department;

    @OneToMany(mappedBy = "furniture",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<FurnitureType> type = new ArrayList<>();

    //    keep both sides in sync(important)
    public void addType(FurnitureType type){
       type.add(type);
        type.setFurniture(this);
    }
}
