package com.example.HKT.service.impl;

import com.example.HKT.DTOs.EssayDto;
import com.example.HKT.entity.EssayEntity;
import com.example.HKT.repository.EssayRepository;
import com.example.HKT.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EssayServiceImpl implements EssayService {

    @Autowired
    private EssayRepository essayRepository;

    @Override
    public List<EssayDto> getAllEssays(){
        List<EssayEntity> receivedEssays = essayRepository.findAll();
        return receivedEssays.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public EssayDto getEssayByid(Integer id){
        EssayEntity Essay = essayRepository.findById(id).orElseThrow(() -> new RuntimeException("Essay with id" + id + "not found"));
        return convertToDto(Essay);
    }

    @Override
    public EssayDto saveNewEssay(EssayDto essay){
        EssayEntity essayEntity = convertToEntity(essay);
        EssayEntity savedEssay = essayRepository.save(essayEntity);
        return convertToDto(savedEssay);
    }

    private EssayDto convertToDto(EssayEntity entity){
        EssayDto dto = new EssayDto();
        dto.setEssayId(entity.getEssayId());
        dto.setEssayContent(entity.getEssayContent());
        dto.setAuthorName(entity.getAuthorName());
        dto.setTitle(entity.getTitle());
        return dto;
    }

    private EssayEntity convertToEntity(EssayDto dto){
        EssayEntity essays = new EssayEntity();
        essays.setEssayId(dto.getEssayId());
        essays.setEssayContent(dto.getEssayContent());
        essays.setAuthorName(dto.getAuthorName());
        essays.setTitle(dto.getTitle());
        return essays;
    }




}
