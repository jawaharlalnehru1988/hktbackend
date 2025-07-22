package com.example.HKT.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/common")
@CrossOrigin(origins = "*")
public class CommonController {

    @GetMapping("/difficulties")
    public ResponseEntity<List<Map<String, Object>>> getDifficulties() {
        List<Map<String, Object>> difficulties = Arrays.asList(
            createDifficultyMap("EASY", "Easy", "#28a745", "Beginner level conflicts"),
            createDifficultyMap("MEDIUM", "Medium", "#ffc107", "Intermediate level conflicts"),
            createDifficultyMap("HARD", "Hard", "#dc3545", "Advanced level conflicts")
        );
        return ResponseEntity.ok(difficulties);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Map<String, Object>>> getCategories() {
        List<Map<String, Object>> categories = Arrays.asList(
            createCategoryMap("RELATIONSHIP", "Relationship", "👥", "Family and interpersonal conflicts"),
            createCategoryMap("WORKPLACE", "Workplace", "💼", "Professional and office conflicts"),
            createCategoryMap("COMMUNICATION", "Communication", "💬", "Communication related issues"),
            createCategoryMap("PERSONAL", "Personal", "🧘", "Personal and self-development"),
            createCategoryMap("SPIRITUAL", "Spiritual", "🕉️", "Spiritual and religious matters"),
            createCategoryMap("LIFESTYLE", "Lifestyle", "🌱", "Daily life and habits"),
            createCategoryMap("DECISION_MAKING", "Decision Making", "🤔", "Choice and decision conflicts")
        );
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/read-times")
    public ResponseEntity<List<String>> getReadTimes() {
        List<String> readTimes = Arrays.asList(
            "2 min read",
            "3 min read",
            "5 min read",
            "7 min read",
            "10 min read",
            "15 min read"
        );
        return ResponseEntity.ok(readTimes);
    }

    @GetMapping("/icons")
    public ResponseEntity<List<Map<String, String>>> getIcons() {
        List<Map<String, String>> icons = Arrays.asList(
            createIconMap("conflict", "⚡", "General conflict icon"),
            createIconMap("peace", "☮️", "Peace and resolution"),
            createIconMap("communication", "💬", "Communication"),
            createIconMap("heart", "❤️", "Relationships and love"),
            createIconMap("lightbulb", "💡", "Ideas and solutions"),
            createIconMap("balance", "⚖️", "Balance and fairness"),
            createIconMap("handshake", "🤝", "Agreement and cooperation"),
            createIconMap("meditation", "🧘", "Mindfulness and calm"),
            createIconMap("growth", "🌱", "Personal growth"),
            createIconMap("wisdom", "🦉", "Wisdom and knowledge")
        );
        return ResponseEntity.ok(icons);
    }

    @GetMapping("/app-config")
    public ResponseEntity<Map<String, Object>> getAppConfig() {
        Map<String, Object> config = new HashMap<>();
        config.put("appName", "HKT - Hare Krishna Teachings");
        config.put("version", "1.0.0");
        config.put("apiVersion", "v1");
        config.put("maxArticleLength", 5000);
        config.put("maxSolutionsCount", 10);
        config.put("maxCausesCount", 10);
        config.put("maxTipsCount", 15);
        config.put("supportEmail", "support@hkt.com");
        config.put("websiteUrl", "https://hkt.railway.app");
        
        Map<String, String> socialLinks = new HashMap<>();
        socialLinks.put("facebook", "https://facebook.com/hkt");
        socialLinks.put("twitter", "https://twitter.com/hkt");
        socialLinks.put("instagram", "https://instagram.com/hkt");
        config.put("socialLinks", socialLinks);
        
        return ResponseEntity.ok(config);
    }

    @GetMapping("/quotes")
    public ResponseEntity<List<Map<String, String>>> getInspirationalQuotes() {
        List<Map<String, String>> quotes = Arrays.asList(
            createQuoteMap("The best way to resolve conflict is to understand each other.", "Krishna"),
            createQuoteMap("Peace comes from within. Do not seek it without.", "Buddha"),
            createQuoteMap("In the middle of difficulty lies opportunity.", "Albert Einstein"),
            createQuoteMap("The greatest weapon against stress is our ability to choose one thought over another.", "William James"),
            createQuoteMap("Conflicts cannot survive without your participation.", "Wayne Dyer"),
            createQuoteMap("Listen with the intent to understand, not the intent to reply.", "Stephen Covey")
        );
        return ResponseEntity.ok(quotes);
    }

    @GetMapping("/solution-templates")
    public ResponseEntity<List<Map<String, Object>>> getSolutionTemplates() {
        List<Map<String, Object>> templates = Arrays.asList(
            createTemplateMap("communication", "Communication Approach", "Start with understanding the other person's perspective"),
            createTemplateMap("compromise", "Compromise Solution", "Find a middle ground that works for everyone"),
            createTemplateMap("meditation", "Meditation Practice", "Take time for quiet reflection and inner peace"),
            createTemplateMap("dialogue", "Open Dialogue", "Create a safe space for honest conversation"),
            createTemplateMap("forgiveness", "Forgiveness Path", "Practice forgiveness for healing and moving forward"),
            createTemplateMap("boundaries", "Healthy Boundaries", "Establish clear and respectful boundaries")
        );
        return ResponseEntity.ok(templates);
    }

    @GetMapping("/all-static-data")
    public ResponseEntity<Map<String, Object>> getAllStaticData() {
        Map<String, Object> allData = new HashMap<>();
        allData.put("difficulties", getDifficulties().getBody());
        allData.put("categories", getCategories().getBody());
        allData.put("readTimes", getReadTimes().getBody());
        allData.put("icons", getIcons().getBody());
        allData.put("appConfig", getAppConfig().getBody());
        allData.put("quotes", getInspirationalQuotes().getBody());
        allData.put("solutionTemplates", getSolutionTemplates().getBody());
        return ResponseEntity.ok(allData);
    }

    // Helper methods
    private Map<String, Object> createDifficultyMap(String value, String label, String color, String description) {
        Map<String, Object> difficulty = new HashMap<>();
        difficulty.put("value", value);
        difficulty.put("label", label);
        difficulty.put("color", color);
        difficulty.put("description", description);
        return difficulty;
    }

    private Map<String, Object> createCategoryMap(String value, String label, String icon, String description) {
        Map<String, Object> category = new HashMap<>();
        category.put("value", value);
        category.put("label", label);
        category.put("icon", icon);
        category.put("description", description);
        return category;
    }

    private Map<String, String> createIconMap(String name, String emoji, String description) {
        Map<String, String> icon = new HashMap<>();
        icon.put("name", name);
        icon.put("emoji", emoji);
        icon.put("description", description);
        return icon;
    }

    private Map<String, String> createQuoteMap(String text, String author) {
        Map<String, String> quote = new HashMap<>();
        quote.put("text", text);
        quote.put("author", author);
        return quote;
    }

    private Map<String, Object> createTemplateMap(String type, String title, String description) {
        Map<String, Object> template = new HashMap<>();
        template.put("type", type);
        template.put("title", title);
        template.put("description", description);
        return template;
    }
}
