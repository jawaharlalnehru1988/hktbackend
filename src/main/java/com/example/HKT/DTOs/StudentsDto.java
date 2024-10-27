package com.example.HKT.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class StudentsDto {
    private Integer id;
    private String Student_Name;
    private Integer age;
    private String city;
}
