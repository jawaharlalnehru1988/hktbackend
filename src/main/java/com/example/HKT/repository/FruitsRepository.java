package com.example.HKT.repository;

import com.example.HKT.entity.Fruits;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitsRepository extends JpaRepository<Fruits, Integer> {
}