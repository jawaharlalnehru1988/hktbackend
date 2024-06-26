package com.example.HKT.controller;

import com.example.HKT.entity.ApiResponse;
import com.example.HKT.entity.Essay;
import com.example.HKT.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/essays")
public class EssayController {
    @Autowired
    private EssayService essayService;

    @GetMapping()
    public List<Essay> getAllEssays(){
        return essayService.getAllEssays();
    }

    @GetMapping("/{id}")
    public Essay getEssayById(@PathVariable int id){
        return essayService.getEssayById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<Essay> createEssays(@RequestBody Essay essay){
        Essay createdEssay = essayService.createEssay(essay);
              return new ApiResponse<>("Successfull Added", createdEssay);
    }

    @PutMapping("/{id}")
    public ApiResponse<Essay> updateEssay(@PathVariable int id, @RequestBody Essay essayDetails) {
        Essay updatedEssay = essayService.updateEssay(id, essayDetails);
        return new ApiResponse<>("Successfully updated", updatedEssay);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ApiResponse<Void> deleteEssay(@PathVariable int id) {
        essayService.deleteEssay(id);
        return new ApiResponse<>("Successfully deleted", null);
    }
}
