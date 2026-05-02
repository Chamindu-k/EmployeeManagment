package com.chamindu.demo.controller;

import com.chamindu.demo.model.dto.EmployeeDTO;
import com.chamindu.demo.model.dto.FurnitureDTO;
import com.chamindu.demo.model.entity.Furniture;
import com.chamindu.demo.service.FurnitureService;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<FurnitureDTO> addFurniture (FurnitureDTO furnitureDTO){
        FurnitureDTO created = furnitureService.addFurniture(furnitureDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    @GetMapping
    public ResponseEntity<List<FurnitureDTO>>getFurniture(){
        return ResponseEntity.ok(furnitureService.getAllFurniture());
    }
    @PutMapping("/{id}")
    public FurnitureDTO updateFurniture (@PathVariable Long id,@RequestBody FurnitureDTO furnitureDTO){
        return furnitureService.updateFurniture(id, furnitureDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable  Long id){
        furnitureService.deleteFurniture(id);
        return ResponseEntity.noContent().build();
    }
}