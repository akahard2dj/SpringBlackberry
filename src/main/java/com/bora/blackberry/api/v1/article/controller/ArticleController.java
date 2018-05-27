package com.bora.blackberry.api.v1.article.controller;

import com.bora.blackberry.api.v1.article.form.ArticleForm;
import com.bora.blackberry.api.v1.article.vo.ArticleVO;
import com.bora.blackberry.api.v1.domain.article.service.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/articles/boards/{boardId}")
    public ResponseEntity<?> getArticles(@PathVariable long boardId) {

        List<ArticleVO> articleVOList = articleService.getArticles(boardId).stream()
                .map(article -> modelMapper.map(article, ArticleVO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(articleVOList);
    }

    @PostMapping("/articles/boards/{boardId}")
    public ResponseEntity<?> createArticle(@PathVariable long boardId,
                                           @RequestBody ArticleForm articleForm) {

        long id = articleService.createArticle(boardId, articleForm);

        Map<String, Long> result = new HashMap<>();
        result.put("id", id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/articles/{articleId}")
    public ResponseEntity<?> updateArticle(@PathVariable long articleId,
                                           @RequestBody ArticleForm articleForm) {
        articleService.updateArticle(articleId, articleForm);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/articles/{articleId}")
    public ResponseEntity<?> deleteArticle(@PathVariable long articleId) {
        articleService.deleteArticle(articleId);

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
