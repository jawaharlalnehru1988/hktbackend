package com.example.HKT.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentsDto {
    private Integer id;
    private String Student_Name;
    private Integer age;
    private String city;
}
