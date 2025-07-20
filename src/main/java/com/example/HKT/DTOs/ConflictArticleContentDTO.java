package com.example.HKT.DTOs;

import lombok.Data;
import java.util.List;

@Data
public class ConflictArticleContentDTO {
    private String problem;
    private List<String> causes;
    private List<String> solutions;
    private List<String> tips;
    private String conclusion;
}