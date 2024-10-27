package com.example.HKT.controller;

import com.example.HKT.DTOs.StudentsDto;
import com.example.HKT.Message.CustomResponse;
import com.example.HKT.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping("/all")
    public ResponseEntity<List<StudentsDto>> getAllStudentsData(){
        List<StudentsDto> studentList = studentsService.getAllStudents();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentsDto> getStudentById(@PathVariable Integer id){
        StudentsDto student = studentsService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/keys")
    public ResponseEntity<List<String>> getStudentKeys(){
        List<String> keys = getFieldNames(StudentsDto.class);
        return new ResponseEntity<>(keys, HttpStatus.OK);
    }

    private List<String> getFieldNames(Class<?> clazz){
        return Arrays.stream(clazz.getDeclaredFields()).map(Field::getName).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Integer id){
        studentsService.deleteStudentsById(id);
        return new ResponseEntity<>("Student with ID " + id + " deleted successfully.", HttpStatus.OK);

    }

    @PostMapping("/studentCreated")
    public ResponseEntity<CustomResponse<StudentsDto>> createStudentConfig(@RequestBody StudentsDto dto){
    StudentsDto createStudent = studentsService.createStudentConfig(dto);

        CustomResponse<StudentsDto> response = new CustomResponse<>("New data create Successfully", createStudent);
    return new ResponseEntity<>(response, HttpStatus.OK);
}

@GetMapping("/count")
public ResponseEntity<Long> getStudentCount(){
        Long count = studentsService.getStudentsCount();
        return new ResponseEntity<>(count, HttpStatus.OK);
}
    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<StudentsDto> updateStudentConfig(@PathVariable Integer id, @RequestBody StudentsDto dto) {
        StudentsDto updatedStudent = studentsService.updateStudentConfig(id, dto);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }


}
