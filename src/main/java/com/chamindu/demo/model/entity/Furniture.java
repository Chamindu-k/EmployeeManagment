package com.chamindu.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;

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
    private Long id ;
    private String name;
    private String department;

}
