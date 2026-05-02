package Mapper;

import com.chamindu.demo.model.dto.EmployeeDTO;
import com.chamindu.demo.model.dto.FurnitureDTO;
import com.chamindu.demo.model.entity.Employee;
import com.chamindu.demo.model.entity.Furniture;

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
}
