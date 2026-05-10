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
public class FurnitureTypeDTO {
    private Long id;
    private String furnitureBrand;
    private String furnitureType;

}

