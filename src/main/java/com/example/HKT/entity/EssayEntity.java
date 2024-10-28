package com.example.HKT.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Essays")
public class EssayEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "essayId")
    private Integer essayId;

    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "essay_content")
    private String essayContent;

    @Column(name = "author_name")
    private String authorName;


}
