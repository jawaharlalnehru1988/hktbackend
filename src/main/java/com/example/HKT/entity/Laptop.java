package com.example.HKT.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "jpa_laptops")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int laptopId;
    private String modelNumber;
    private String brand;

    @OneToOne
    @JoinColumn(name = "students_id")
    private StudentsEntity students;

}
