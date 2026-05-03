package com.chamindu.demo.mapper;

import com.chamindu.demo.model.dto.EmployeeDTO;
import com.chamindu.demo.model.dto.FurnitureDTO;
import com.chamindu.demo.model.entity.Employee;
import com.chamindu.demo.model.entity.Furniture;

import java.util.List;
import java.util.Objects;

/**
 * Author by chamindu_kaushalya
 */
public class FurnitureMapper {
    public static Furniture toEntity(FurnitureDTO dto){
        return Furniture.builder()
                .name(dto.getName())
                .department(dto.getDepartment())
                .build();
    }
    public static FurnitureDTO toDto(Furniture entity){
        return FurnitureDTO.builder()
                .name(entity.getName())
                .department(entity.getDepartment())
                .build();
    }
    public static List<FurnitureDTO> toDTOList(List<Furniture> furnitureList){
        if(furnitureList == null | furnitureList.isEmpty()) return List.of();

        return furnitureList.stream()
                .filter(Objects::nonNull)
                .map(FurnitureMapper::toDto)
                .toList();

    }
}
