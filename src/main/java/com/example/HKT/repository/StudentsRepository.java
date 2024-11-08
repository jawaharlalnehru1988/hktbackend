package com.example.HKT.repository;

import com.example.HKT.entity.StudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentsRepository extends JpaRepository<StudentsEntity, Integer> {
//    Optional<StudentsEntity> findByStudentName(String studentName);
}
