package com.example.HKT.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class FruitsDto {
    private Integer id;
    private String name;
    private BigDecimal price;
    private String image;
}
