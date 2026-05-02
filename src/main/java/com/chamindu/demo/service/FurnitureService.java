package com.chamindu.demo.service;

import Mapper.EmployeeMapper;
import Mapper.FurnitureMapper;
import com.chamindu.demo.model.dto.EmployeeDTO;
import com.chamindu.demo.model.dto.FurnitureDTO;
import com.chamindu.demo.model.entity.Employee;
import com.chamindu.demo.model.entity.Furniture;
import com.chamindu.demo.repository.EmployeeRepository;
import com.chamindu.demo.repository.FurnitureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Author by chamindu_kaushalya
 */
@Service
@RequiredArgsConstructor
public class FurnitureService {
    private final FurnitureRepository furnitureRepository;

    public FurnitureDTO addFurniture(FurnitureDTO dto){
        furnitureRepository.save(FurnitureMapper.toEntity(dto));
        return dto;
    }
    public List<FurnitureDTO> getAllFurniture(){
        return furnitureRepository.findAll()
                .stream()
                .map(FurnitureMapper::toDto)
                .toList();
    }
    public FurnitureDTO updateFurniture(Long id,FurnitureDTO furnitureDTO){
        Optional<Furniture> furniture = furnitureRepository.findById(id);

        Furniture updateFurniture = furniture.get();

        updateFurniture.setName(furnitureDTO.getName());
        updateFurniture.setDepartment(furnitureDTO.getDepartment());
       furnitureRepository.save(updateFurniture);

        return FurnitureMapper.toDto(updateFurniture);
    }

    public void deleteFurniture(Long id){
        Optional<Furniture> furniture = furnitureRepository.findById(id);
        furnitureRepository.delete(furniture.get());

    }
}