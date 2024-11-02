package com.example.HKT.DTOs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    public String name;
    public int age;
    public Float marks;

    public boolean isAbove(){
        return age>25;
    }
}
