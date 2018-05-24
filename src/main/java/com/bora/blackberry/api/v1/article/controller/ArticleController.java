package com.bora.blackberry.api.v1.article.controller;

import com.bora.blackberry.api.v1.article.vo.ArticleVO;
import com.bora.blackberry.api.v1.domain.article.service.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
}
