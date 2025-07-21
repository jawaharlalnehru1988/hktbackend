package com.example.HKT.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ConflictArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String subtitle;

    @Lob
    private String icon;
    private String category;
    private String readTime;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    private String summary;

    @OneToOne(mappedBy = "article", cascade = CascadeType.ALL)
    private ConflictArticleContent content;

    public enum Difficulty {
        EASY, MEDIUM, HARD
    }
}