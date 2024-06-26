package com.example.HKT.service;

import com.example.HKT.entity.Essay;
import com.example.HKT.repository.EssayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EssayService {
    @Autowired
    private EssayRepository essayRepository;

    public List<Essay> getAllEssays(){
        return essayRepository.findAll();
    }

    public Essay getEssayById(int id){
        return essayRepository.findById(id).orElse(null);
    }

    public Essay createEssay(Essay essay){
        return essayRepository.save(essay);
    }

    public Essay updateEssay(int id, Essay essayDetails){
        Essay essay = essayRepository.findById(id).orElse(null);
        if(essay != null) {
            essay.setTitle(essayDetails.getTitle());
            essay.setAuthorName(essayDetails.getAuthorName());
            essay.setEssayContent(essayDetails.getEssayContent());
            return essayRepository.save(essay);
        }
        return null;
    }

    public void deleteEssay(int id){
        essayRepository.deleteById(id);
    }
}
