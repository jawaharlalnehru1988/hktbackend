package com.example.HKT.repository;

import com.example.HKT.entity.FruitsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitsRepository extends JpaRepository<FruitsEntity, Integer> {
}
