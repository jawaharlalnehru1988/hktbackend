package com.example.HKT.DTOs;

import lombok.Data;

@Data
public class EssayDto {
    private Integer essayId;
    private String title;
    private String essayContent;
    private String authorName;
}
