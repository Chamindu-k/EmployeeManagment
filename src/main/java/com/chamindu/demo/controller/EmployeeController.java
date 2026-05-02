package com.chamindu.demo.controller;

import com.chamindu.demo.model.dto.ApiResponse;
import com.chamindu.demo.model.dto.EmployeeDTO;
import com.chamindu.demo.model.entity.Employee;
import com.chamindu.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author by chamindu_kaushalya
 */
@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ApiResponse<EmployeeDTO> addEmployee (EmployeeDTO employeeDTO){
        return employeeService.addEmployee(employeeDTO);
    }

    @GetMapping
    public ApiResponse<List<EmployeeDTO>> getEmployee(){
        return employeeService.getAllEmployee();
    }
    @PutMapping("/{id}")
    public ApiResponse<EmployeeDTO>  updateEmployee (@PathVariable Long id,@RequestBody EmployeeDTO employeeDTO){
        return employeeService.updateEmployee(id, employeeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable  Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}

