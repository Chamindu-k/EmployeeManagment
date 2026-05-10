package com.chamindu.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;
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
    private Long id;
    private String name;
    private String department;

    @OneToMany(mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<EmployeeSkills> skills = new ArrayList<>();

    //    keep both sides in sync(important)
    public void addSkills(EmployeeSkills skill){
        skills.add(skill);
        skill.setEmployee(this);
    }
}
