package com.chamindu.demo.service;

import com.chamindu.demo.mapper.EmployeeMapper;
import com.chamindu.demo.model.dto.ApiResponse;
import com.chamindu.demo.model.dto.EmployeeDTO;
import com.chamindu.demo.model.entity.Employee;
import com.chamindu.demo.model.entity.EmployeeSkills;
import com.chamindu.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Author by chamindu_kaushalya
 */
@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public ApiResponse<EmployeeDTO> addEmployee(EmployeeDTO dto) {
//        add employee details
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setDepartment(dto.getDepartment());

//        add each row in skill table
        if(dto.getSkills() != null){
            employee.setSkills(new ArrayList<>());
            for(var s : dto.getSkills()){
                EmployeeSkills skill = new EmployeeSkills();
                skill.setSkillName(s.getSkillName());
                skill.setSkillLevel(s.getSkillLevel());
                employee.addSkills(skill);
            }
        }

        employeeRepository.save(employee);

        return ApiResponse.<EmployeeDTO>builder()
                .success(true)
                .message("Employee created successfully")
                .timestamp(LocalDateTime.now())
                .data(EmployeeMapper.toDto(employee))
                .build();
    }

    public ApiResponse<List<EmployeeDTO>> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();

        if (employees.isEmpty()) {
            return ApiResponse.<List<EmployeeDTO>>builder()
                    .success(true)
                    .message("Employee not found")
                    .timestamp(LocalDateTime.now())
                    .build();
        }

        return ApiResponse.<List<EmployeeDTO>>builder()
                .success(true)
                .message("Employee fetched successfully")
                .count(employees.size())
                .timestamp(LocalDateTime.now())
                .data(EmployeeMapper.toDTOList(employees))
                .build();
    }

    public ApiResponse<EmployeeDTO> updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Optional<Employee> employee = employeeRepository.findById(id);

        Employee updateEmployee = employee.get();

        updateEmployee.setName(employeeDTO.getName());
        updateEmployee.setDepartment(employeeDTO.getDepartment());
        employeeRepository.save(updateEmployee);

        return ApiResponse.<EmployeeDTO>builder()
                .success(true)
                .message("Employee updated sucessfully")
                .timestamp(LocalDateTime.now())
                .data(employeeDTO)
                .build();
    }

    public void deleteEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        employeeRepository.delete(employee.get());

    }

    public ApiResponse<EmployeeDTO> getEmployeeById(Long id){
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isEmpty()) {
            return ApiResponse.<EmployeeDTO>builder()
                    .success(true)
                    .message("Employee not found")
                    .timestamp(LocalDateTime.now())
                    .build();
        }

        return ApiResponse.<EmployeeDTO>builder()
                .success(true)
                .message("Employee fetched successfully")
                .timestamp(LocalDateTime.now())
                .data(EmployeeMapper.toDto(employee.get()))
                .build();
    }
}

