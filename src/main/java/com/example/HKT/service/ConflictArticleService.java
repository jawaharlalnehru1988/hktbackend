package com.example.HKT.service;


import com.example.HKT.DTOs.ConflictArticleDTO;

import java.util.List;

public interface ConflictArticleService {
    ConflictArticleDTO createArticle(ConflictArticleDTO articleDTO);
    List<ConflictArticleDTO> getAllArticles();
    ConflictArticleDTO getArticleById(Long id);
    void deleteArticle(Long id);
}