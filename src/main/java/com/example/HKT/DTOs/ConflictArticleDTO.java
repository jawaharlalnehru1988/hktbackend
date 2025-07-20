package com.example.HKT.DTOs;//package com.example.HKT.dto;

import lombok.Data;

@Data
public class ConflictArticleDTO {
    private Long id;
    private String title;
    private String subtitle;
    private String icon;
    private String category;
    private String readTime;
    private String difficulty;
    private String summary;
    private ConflictArticleContentDTO content;
}