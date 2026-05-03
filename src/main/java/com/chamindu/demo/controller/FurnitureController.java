package com.chamindu.demo.controller;

import com.chamindu.demo.model.dto.ApiResponse;
import com.chamindu.demo.model.dto.EmployeeDTO;
import com.chamindu.demo.model.dto.FurnitureDTO;
import com.chamindu.demo.model.entity.Employee;
import com.chamindu.demo.service.EmployeeService;
import com.chamindu.demo.service.FurnitureService;
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
@RequestMapping("/api/furniture")
@RequiredArgsConstructor
public class FurnitureController {
    private final FurnitureService furnitureService;

    @PostMapping
    public ApiResponse<FurnitureDTO> addFurniture (FurnitureDTO furnitureDTO){
        return furnitureService.addFurniture(furnitureDTO);
    }

    @GetMapping
    public ApiResponse<List<FurnitureDTO>> getFurniture(){
        return furnitureService.getAllFurniture();
    }
    @PutMapping("/{id}")
    public ApiResponse<FurnitureDTO>  updateFurniture (@PathVariable Long id,@RequestBody FurnitureDTO furnitureDTO){
        return furnitureService.updateFurniture(id, furnitureDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFurniture(@PathVariable  Long id){
        furnitureService.deleteFurniture(id);
        return ResponseEntity.noContent().build();
    }
}

