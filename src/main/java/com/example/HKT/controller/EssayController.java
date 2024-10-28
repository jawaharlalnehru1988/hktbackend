package com.example.HKT.controller;

import com.example.HKT.DTOs.EssayDto;
import com.example.HKT.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("essays")
public class EssayController {
    @Autowired
    private EssayService essayService;

    @GetMapping
    public ResponseEntity<List<EssayDto>> getAllEssays(){
       List<EssayDto> fetchedDatas = essayService.getAllEssays();
       return new ResponseEntity<>(fetchedDatas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EssayDto> getEssayById(@PathVariable Integer id){
        EssayDto essay = essayService.getEssayByid(id);
        return new ResponseEntity<>(essay, HttpStatus.OK);
    }

    @PostMapping("/addEssay")
    public ResponseEntity<EssayDto> createNewEssay(@RequestBody EssayDto essay){
        EssayDto newEssay = essayService.saveNewEssay(essay);
        return new ResponseEntity<>(newEssay, HttpStatus.OK);
    }

}
