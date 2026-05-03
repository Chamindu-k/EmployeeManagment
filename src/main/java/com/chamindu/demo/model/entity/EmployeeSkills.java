package com.chamindu.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Author by chamindu_kaushalya
 */
@Entity
@Table(name="employee_skills")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSkills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skillName;
    private String skillLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
}

