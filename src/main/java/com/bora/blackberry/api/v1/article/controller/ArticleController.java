package com.bora.blackberry.api.v1.article.controller;

import com.bora.blackberry.api.v1.article.form.ArticleForm;
import com.bora.blackberry.api.v1.article.vo.ArticleVO;
import com.bora.blackberry.api.v1.common.ResponseWrapper;
import com.bora.blackberry.domain.article.service.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseWrapper getArticles(@PathVariable long boardId) {

        List<ArticleVO> articleVOList = articleService.getArticles(boardId).stream()
                .map(article -> modelMapper.map(article, ArticleVO.class))
                .collect(Collectors.toList());

        return ResponseWrapper.ok(articleVOList);
    }

    @PostMapping("/articles/boards/{boardId}")
    public ResponseWrapper createArticle(@PathVariable long boardId,
                                           @RequestBody ArticleForm articleForm) {

        long id = articleService.createArticle(boardId, articleForm);

        Map<String, Long> result = new HashMap<>();
        result.put("id", id);
        return ResponseWrapper.ok(result);
    }

    @PutMapping("/articles/{articleId}")
    public ResponseWrapper updateArticle(@PathVariable long articleId,
                                           @RequestBody ArticleForm articleForm) {
        articleService.updateArticle(articleId, articleForm);

        return ResponseWrapper.ok();
    }

    @DeleteMapping("/articles/{articleId}")
    public ResponseWrapper deleteArticle(@PathVariable long articleId) {
        articleService.deleteArticle(articleId);

        return ResponseWrapper.ok();
    }
}
