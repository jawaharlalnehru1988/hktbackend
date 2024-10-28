package com.example.HKT.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressDto {
    private Integer id;
    private Integer number;
    private String street;
    private String postcode;
    private String name;
}
