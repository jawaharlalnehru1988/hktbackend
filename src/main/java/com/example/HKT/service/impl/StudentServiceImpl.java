package com.example.HKT.service.impl;

import com.example.HKT.DTOs.StudentsDto;
import com.example.HKT.entity.StudentsEntity;
import com.example.HKT.repository.StudentsRepository;
import com.example.HKT.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentsService {

    @Autowired
    private StudentsRepository repository;

    @Override
    public List<StudentsDto> getAllStudents(){
        List<StudentsEntity> studentList = repository.findAll();
        return studentList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public StudentsDto createStudentConfig(StudentsDto dto){
        StudentsEntity students = convertToEntity(dto);
        students = repository.save(students);
        return convertToDto(students);
    }

    @Override
    public StudentsDto updateStudentConfig(Integer id, StudentsDto dto){
        StudentsEntity students = repository.findById(id).orElseThrow(() -> new RuntimeException(("Student not found with id:" + dto)));
        students.setStudent_Name(dto.getStudent_Name());
        students.setAge(dto.getAge());
        students.setCity(dto.getCity());
        students = repository.save(students);
        return convertToDto(students);
    }

    @Override
    public void deleteStudentsById(Integer id){
        StudentsEntity students = repository.findById(id).orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        repository.delete(students);
    }

    @Override
    public StudentsDto getStudentById(Integer id){
        StudentsEntity student = repository.findById(id).orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        return convertToDto(student);
    }
    @Override
    public Long getStudentsCount(){
        return repository.count();

    }



    private StudentsEntity convertToEntity(StudentsDto dto){
        StudentsEntity entity = new StudentsEntity();
        entity.setId(dto.getId());
        entity.setAge(dto.getAge());
        entity.setCity(dto.getCity());
        entity.setStudent_Name(dto.getStudent_Name());
        return entity;
    }

    private StudentsDto convertToDto(StudentsEntity students){
        StudentsDto dto = new StudentsDto();
        dto.setId(students.getId());
        dto.setAge(students.getAge());
        dto.setCity(students.getCity());
        dto.setStudent_Name(students.getStudent_Name());
        return dto;
    }

}
