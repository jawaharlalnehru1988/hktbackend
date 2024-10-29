package com.example.HKT.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Students")
public class StudentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="Student_Name")
    private String  Student_Name;

    @Column(name="Age")
    private Integer age;

    @Column(name = "City")
    private String city;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "students")
    @JoinColumn(name = "laptop_id")
    private Laptop laptop;
}
