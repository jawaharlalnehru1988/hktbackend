package com.example.HKT.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Essays")
public class Essay {

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

    public Integer getEssayId() {
        return essayId;
    }

    public void setEssayId(Integer essayId) {
        this.essayId = essayId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEssayContent() {
        return essayContent;
    }

    public void setEssayContent(String essayContent) {
        this.essayContent = essayContent;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }


}
