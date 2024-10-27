package com.example.HKT.repository;

import com.example.HKT.entity.StudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<StudentsEntity, Integer> {
}
