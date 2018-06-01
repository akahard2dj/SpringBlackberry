package com.bora.blackberry.api.v1.article.controller;

import com.bora.blackberry.api.v1.article.form.ArticleForm;
import com.bora.blackberry.api.v1.article.vo.ArticleSimpleVO;
import com.bora.blackberry.api.v1.article.vo.ArticleVO;
import com.bora.blackberry.api.v1.common.ResponseWrapper;
import com.bora.blackberry.api.v1.common.exception.CommonException;
import com.bora.blackberry.domain.article.entity.Article;
import com.bora.blackberry.domain.article.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "게시글")
@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/articles/boards/{boardId}")
    @ApiOperation(value = "게시판 글목록 조회", notes = "게시판 글목록 조회")
    public ResponseWrapper getArticles(@PathVariable long boardId) {

        List<ArticleSimpleVO> articleVOList = articleService.getArticles(boardId).stream()
                .map(article -> modelMapper.map(article, ArticleSimpleVO.class))
                .collect(Collectors.toList());

        return ResponseWrapper.ok(articleVOList);
    }

    @GetMapping("/articles/{articleId}")
    @ApiOperation(value = "특정 글 상세 조회", notes = "특정 글 상세 조회")
    public ResponseWrapper getDetailArticle(@PathVariable long articleId) {

        Article article = articleService.getDetailArticle(articleId);
        if (article == null) {
            throw new CommonException("Not found article, id: " + articleId);
        }
        return ResponseWrapper.ok(modelMapper.map(article, ArticleVO.class));
    }

    @PostMapping("/articles/boards/{boardId}")
    @ApiOperation(value = "글 생성", notes = "글 생성")
    public ResponseWrapper createArticle(@PathVariable long boardId,
                                         @Valid @RequestBody ArticleForm articleForm) {

        long id = articleService.createArticle(boardId, articleForm);
        return ResponseWrapper.ok(id);
    }

    @PutMapping("/articles/{articleId}")
    @ApiOperation(value = "글 수정", notes = "글 수정")
    public ResponseWrapper updateArticle(@PathVariable long articleId,
                                         @Valid @RequestBody ArticleForm articleForm) {
        articleService.updateArticle(articleId, articleForm);

        return ResponseWrapper.ok();
    }

    @DeleteMapping("/articles/{articleId}")
    @ApiOperation(value = "글 삭제", notes = "글 삭제")
    public ResponseWrapper deleteArticle(@PathVariable long articleId) {
        articleService.deleteArticle(articleId);

        return ResponseWrapper.ok();
    }

    @PutMapping("/articles/{articleId}/like")
    @ApiOperation(value = "좋아요 누르기", notes = "좋아요 누르기")
    public ResponseWrapper increaseLikeCount(@PathVariable long articleId) {
        return ResponseWrapper.ok(articleService.increaseLikeCount(articleId));
    }

    @PutMapping("/articles/{articleId}/dislike")
    @ApiOperation(value = "싫어요 누르기", notes = "싫어요 누르기")
    public ResponseWrapper increaseDislikeCount(@PathVariable long articleId) {
        return ResponseWrapper.ok(articleService.increaseDislikeCount(articleId));
    }
}
