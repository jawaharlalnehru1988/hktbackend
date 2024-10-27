package com.example.HKT.service;

import com.example.HKT.DTOs.StudentsDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentsService {

    public List<StudentsDto> getAllStudents();

    public StudentsDto createStudentConfig(StudentsDto dto);

    public StudentsDto updateStudentConfig(Integer id, StudentsDto dto);

    public void deleteStudentsById(Integer id);
    public Long getStudentsCount();
}
