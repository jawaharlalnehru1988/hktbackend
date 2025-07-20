package com.example.HKT.service.ConflictServiceImpl;

import com.example.HKT.DTOs.ConflictArticleContentDTO;
import com.example.HKT.DTOs.ConflictArticleDTO;
import com.example.HKT.entity.ConflictArticle;
import com.example.HKT.entity.ConflictArticleContent;
import com.example.HKT.repository.ConflictArticleRepository;
import com.example.HKT.service.ConflictArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConflictArticleServiceImpl implements ConflictArticleService {

    @Autowired
    private ConflictArticleRepository articleRepository;

    @Override
    public ConflictArticleDTO createArticle(ConflictArticleDTO articleDTO) {
        // Map DTO to Entity, save, and return the saved DTO
        ConflictArticle article = mapToEntity(articleDTO);
        ConflictArticle savedArticle = articleRepository.save(article);
        return mapToDTO(savedArticle);
    }

    @Override
    public List<ConflictArticleDTO> getAllArticles() {
        return articleRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ConflictArticleDTO getArticleById(Long id) {
        ConflictArticle article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));
        return mapToDTO(article);
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    private ConflictArticle mapToEntity(ConflictArticleDTO dto) {
        ConflictArticle article = new ConflictArticle();
        article.setTitle(dto.getTitle());
        article.setSubtitle(dto.getSubtitle());
        article.setIcon(dto.getIcon());
        article.setCategory(dto.getCategory());
        article.setReadTime(dto.getReadTime());
        article.setDifficulty(ConflictArticle.Difficulty.valueOf(dto.getDifficulty().toUpperCase()));
        article.setSummary(dto.getSummary());

        if (dto.getContent() != null) {
            ConflictArticleContent content = new ConflictArticleContent();
            content.setProblem(dto.getContent().getProblem());
            content.setCauses(dto.getContent().getCauses());
            content.setSolutions(dto.getContent().getSolutions());
            content.setTips(dto.getContent().getTips());
            content.setConclusion(dto.getContent().getConclusion());
            content.setArticle(article); // Link content to the article
            article.setContent(content); // Link article to the content
        }

        return article;
    }

    private ConflictArticleDTO mapToDTO(ConflictArticle entity) {

        // Map Entity to DTO
        ConflictArticleDTO dto = new ConflictArticleDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setSubtitle(entity.getSubtitle());
        dto.setIcon(entity.getIcon());
        dto.setCategory(entity.getCategory());
        dto.setReadTime(entity.getReadTime());
        dto.setDifficulty(entity.getDifficulty().name().toLowerCase());
        dto.setSummary(entity.getSummary());
        if (entity.getContent() != null) {
            ConflictArticleContentDTO contentDTO = new ConflictArticleContentDTO();
            contentDTO.setProblem(entity.getContent().getProblem());
            contentDTO.setCauses(entity.getContent().getCauses());
            contentDTO.setSolutions(entity.getContent().getSolutions());
            contentDTO.setTips(entity.getContent().getTips());
            contentDTO.setConclusion(entity.getContent().getConclusion());
            dto.setContent(contentDTO);
        }


        // Implement mapping logic here
        return dto;
    }
}