package com.chamindu.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author by chamindu_kaushalya
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSkillsDTO {
    private Long id;
    private String skillName;
    private String skillLevel;
}

