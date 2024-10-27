package com.example.HKT.Message;

import com.example.HKT.DTOs.StudentsDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomResponse<StudentsDto> {
    private String message;
    private StudentsDto data;
}
