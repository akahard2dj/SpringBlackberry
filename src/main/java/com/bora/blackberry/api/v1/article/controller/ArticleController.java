package com.bora.blackberry.api.v1.article.controller;

import com.bora.blackberry.api.v1.article.form.ArticleForm;
import com.bora.blackberry.api.v1.article.vo.ArticleSimpleVO;
import com.bora.blackberry.api.v1.article.vo.ArticleVO;
import com.bora.blackberry.api.v1.common.ResponseWrapper;
import com.bora.blackberry.api.v1.common.exception.CommonException;
import com.bora.blackberry.domain.article.entity.Article;
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

        List<ArticleSimpleVO> articleVOList = articleService.getArticles(boardId).stream()
                .map(article -> modelMapper.map(article, ArticleSimpleVO.class))
                .collect(Collectors.toList());

        return ResponseWrapper.ok(articleVOList);
    }

    @GetMapping("/articles/{articleId}")
    public ResponseWrapper getDetailArticle(@PathVariable long articleId) {

        Article article = articleService.getDetailArticle(articleId);
        if (article == null) {
            throw new CommonException("Not found article, id: " + articleId);
        }
        return ResponseWrapper.ok(modelMapper.map(article, ArticleVO.class));
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

    @PutMapping("/articles/{articleId}/like")
    public ResponseWrapper increaseLikeCount(@PathVariable long articleId) {
        return ResponseWrapper.ok(articleService.increaseLikeCount(articleId));
    }

    @PutMapping("/articles/{articleId}/dislike")
    public ResponseWrapper increaseDislikeCount(@PathVariable long articleId) {
        return ResponseWrapper.ok(articleService.increaseDislikeCount(articleId));
    }
}
