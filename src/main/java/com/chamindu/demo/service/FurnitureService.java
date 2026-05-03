package com.chamindu.demo.service;

import com.chamindu.demo.mapper.EmployeeMapper;
import com.chamindu.demo.mapper.FurnitureMapper;
import com.chamindu.demo.model.dto.ApiResponse;
import com.chamindu.demo.model.dto.EmployeeDTO;
import com.chamindu.demo.model.dto.FurnitureDTO;
import com.chamindu.demo.model.entity.Employee;
import com.chamindu.demo.model.entity.Furniture;
import com.chamindu.demo.repository.EmployeeRepository;
import com.chamindu.demo.repository.FurnitureRepository;
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
public class FurnitureService {
    private final FurnitureRepository furnitureRepository;

    public ApiResponse<FurnitureDTO> addFurniture(FurnitureDTO dto){
        furnitureRepository.save(FurnitureMapper.toEntity(dto));
        return ApiResponse.<FurnitureDTO>builder()
                .success(true)
                .message("Furniture created successfully")
                .timestamp(LocalDateTime.now())
                .timestamp(LocalDateTime.now())
                .data(dto)
                .build();
    }

    public ApiResponse<List<FurnitureDTO>> getAllFurniture(){
        List<Furniture> furniture = furnitureRepository.findAll();

        if (furniture.isEmpty()) {
            return ApiResponse.<List<FurnitureDTO>>builder()
                    .success(true)
                    .message("Furniture not found")
                    .timestamp(LocalDateTime.now())
                    .build();
        }

        return ApiResponse.<List<FurnitureDTO>>builder()
                .success(true)
                .message("Furniture fetched sucessfully")
                .count(furniture.size())
                .timestamp(LocalDateTime.now())
                .data(FurnitureMapper.toDTOList(furniture))
                .build();
    }

    public ApiResponse<FurnitureDTO> updateFurniture(Long id,FurnitureDTO furnitureDTO){
        Optional<Furniture> furniture = furnitureRepository.findById(id);

        Furniture updateFurniture = furniture.get();

        updateFurniture.setName(furnitureDTO.getName());
        updateFurniture.setDepartment(furnitureDTO.getDepartment());
        furnitureRepository.save(updateFurniture);

        return  ApiResponse.<FurnitureDTO>builder()
                .success(true)
                .message("Furniture updated sucessfully")
                .timestamp(LocalDateTime.now())
                .data(furnitureDTO)
                .build();
    }

    public void deleteFurniture(Long id){
        Optional<Furniture> furniture = furnitureRepository.findById(id);
       furnitureRepository.delete(furniture.get());

    }

    public ApiResponse<FurnitureDTO> getFurnitureById(Long id){
        Optional<Furniture> furniture = furnitureRepository.findById(id);

        if (furniture.isEmpty()) {
            return ApiResponse.<FurnitureDTO>builder()
                    .success(true)
                    .message("Furniture not found")
                    .timestamp(LocalDateTime.now())
                    .build();
        }

        return ApiResponse.<FurnitureDTO>builder()
                .success(true)
                .message("Furniture fetched sucessfully")
                .timestamp(LocalDateTime.now())
                .data(FurnitureMapper.toDto(furniture.get()))
                .build();
    }
}

