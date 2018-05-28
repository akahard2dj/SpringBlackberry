package com.bora.blackberry.api.v1.article.controller;

import com.bora.blackberry.api.v1.article.form.ArticleForm;
import com.bora.blackberry.api.v1.article.vo.ArticleVO;
import com.bora.blackberry.api.v1.common.ResponseWrapper;
import com.bora.blackberry.domain.article.service.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
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
                                         @Valid @RequestBody ArticleForm articleForm) {

        long id = articleService.createArticle(boardId, articleForm);
        return ResponseWrapper.ok(id);
    }

    @PutMapping("/articles/{articleId}")
    public ResponseWrapper updateArticle(@PathVariable long articleId,
                                         @Valid @RequestBody ArticleForm articleForm) {
        articleService.updateArticle(articleId, articleForm);

        return ResponseWrapper.ok();
    }

    @DeleteMapping("/articles/{articleId}")
    public ResponseWrapper deleteArticle(@PathVariable long articleId) {
        articleService.deleteArticle(articleId);

        return ResponseWrapper.ok();
    }
}
