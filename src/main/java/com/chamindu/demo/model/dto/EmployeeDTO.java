package com.chamindu.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Author by chamindu_kaushalya
 */
@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class EmployeeDTO {
    private Long employeeId ;
    private String name;
    private String department;
}
