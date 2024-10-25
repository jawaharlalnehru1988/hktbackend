package com.example.HKT.service;

import com.example.HKT.entity.Fruits;
import com.example.HKT.repository.FruitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitsService {

    @Autowired
    private FruitsRepository fruitsRepository;

    public List<Fruits> getAllFruits(){
        return fruitsRepository.findAll();
    }
}
