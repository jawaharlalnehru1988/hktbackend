package com.example.HKT.service;


import com.example.HKT.DTOs.EssayDto;

import java.util.List;

public interface EssayService {

    public List<EssayDto> getAllEssays();
    public EssayDto getEssayByid(Integer id);
    public EssayDto saveNewEssay(EssayDto essay);
    public void deleteEssay(Integer id);
    public EssayDto updateEssay(EssayDto essay, Integer id);

}
