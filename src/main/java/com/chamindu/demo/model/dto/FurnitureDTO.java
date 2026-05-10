package com.chamindu.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Author by chamindu_kaushalya
 */
@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class FurnitureDTO {
    private Long id;
    private String name;
    private String department;
    private List<FurnitureTypeDTO> types;

}
