package com.example.HKT.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class ConflictArticleContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String problem;

    @ElementCollection
    private List<String> causes;

    @ElementCollection
    private List<String> solutions;

    @ElementCollection
    private List<String> tips;

    @Column(length = 2000)
    private String conclusion;

    @OneToOne
    @JoinColumn(name = "article_id")
    private ConflictArticle article;
}