package com.example.HKT.service.impl;

import com.example.HKT.DTOs.FruitsDto;
import com.example.HKT.entity.FruitsEntity;
import com.example.HKT.repository.FruitsRepository;
import com.example.HKT.service.FruitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FruitsServiceImpl implements FruitsService {
    @Autowired private FruitsRepository fruitsRepository;

    @Override
    public List<FruitsDto> getAllFruits(){
        List<FruitsEntity> allFruits = fruitsRepository.findAll();
        return allFruits.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private FruitsDto convertToDto(FruitsEntity fruitData){
        FruitsDto dto = new FruitsDto();
        dto.setId(fruitData.getId());
        dto.setName(fruitData.getName());
        dto.setPrice(fruitData.getPrice());
        dto.setImage(fruitData.getImage());
        return dto;
    }
}
