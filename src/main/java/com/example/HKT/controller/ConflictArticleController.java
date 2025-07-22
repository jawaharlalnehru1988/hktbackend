package com.example.HKT.controller;

import com.example.HKT.DTOs.ConflictArticleDTO;
import com.example.HKT.service.ConflictArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
@CrossOrigin(origins = "*")
public class ConflictArticleController {

    @Autowired
    private ConflictArticleService articleService;

    @PostMapping
    public ResponseEntity<ConflictArticleDTO> createArticle(@RequestBody ConflictArticleDTO articleDTO) {
        return ResponseEntity.ok(articleService.createArticle(articleDTO));
    }

    @GetMapping
    public ResponseEntity<List<ConflictArticleDTO>> getAllArticles() {
        return ResponseEntity.ok(articleService.getAllArticles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConflictArticleDTO> getArticleById(@PathVariable Long id) {
        return ResponseEntity.ok(articleService.getArticleById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }
}
