package com.chamindu.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.lang.reflect.GenericArrayType;
import java.util.UUID;

/**
 * Author by chamindu_kaushalya
 */
@Entity
@Table(name="employee")
@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name;
    private String department;

}
