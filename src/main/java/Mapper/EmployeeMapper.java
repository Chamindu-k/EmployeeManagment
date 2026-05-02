package Mapper;

import com.chamindu.demo.model.dto.EmployeeDTO;
import com.chamindu.demo.model.entity.Employee;

import java.util.List;
import java.util.Objects;

/**
 * Author by chamindu_kaushalya
 */
public class EmployeeMapper {
    public static Employee toEntity(EmployeeDTO dto){
        return Employee.builder()
                .name(dto.getName())
                .department(dto.getDepartment())
                .build();
    }
    public static EmployeeDTO toDto(Employee entity){
        return EmployeeDTO.builder()
                .name(entity.getName())
                .department(entity.getDepartment())
                .build();
    }

    public static List<EmployeeDTO> toDTOList(List<Employee> employeeList){
        if(employeeList == null | employeeList.isEmpty()) return List.of();

        return employeeList.stream()
                .filter(Objects::nonNull)
                .map(EmployeeMapper::toDto)
                .toList();

    }
}
