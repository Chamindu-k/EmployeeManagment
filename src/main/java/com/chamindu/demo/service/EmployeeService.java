package com.chamindu.demo.service;

import com.chamindu.demo.mapper.EmployeeMapper;
import com.chamindu.demo.model.dto.ApiResponse;
import com.chamindu.demo.model.dto.EmployeeDTO;
import com.chamindu.demo.model.entity.Employee;
import com.chamindu.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Author by chamindu_kaushalya
 */
@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public ApiResponse<EmployeeDTO> addEmployee(EmployeeDTO dto){
        employeeRepository.save(EmployeeMapper.toEntity(dto));
        return ApiResponse.<EmployeeDTO>builder()
                .success(true)
                .message("Employee created successfully")
                .timestamp(LocalDateTime.now())
                .timestamp(LocalDateTime.now())
                .data(dto)
                .build();
    }
public ApiResponse<List<EmployeeDTO>> getAllEmployee(){
        List<Employee> employees = employeeRepository.findAll();

   return ApiResponse.<List<EmployeeDTO>>builder()
           .success(true)
           .message("Employee fetched sucessfully")
           .count(employees.size())
           .timestamp(LocalDateTime.now())
           .data(EmployeeMapper.toDTOList(employees))
           .build();


}
public ApiResponse<EmployeeDTO> updateEmployee(Long id,EmployeeDTO employeeDTO){
    Optional<Employee> employee = employeeRepository.findById(id);

    Employee updateEmployee = employee.get();

    updateEmployee.setName(employeeDTO.getName());
    updateEmployee.setDepartment(employeeDTO.getDepartment());
    employeeRepository.save(updateEmployee);

    return  ApiResponse.<EmployeeDTO>builder()
            .success(true)
            .message("Employee updated sucessfully")
            .timestamp(LocalDateTime.now())
            .data(employeeDTO)
            .build();
}

public void deleteEmployee(Long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        employeeRepository.delete(employee.get());

    }
}

