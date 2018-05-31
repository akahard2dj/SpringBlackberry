package com.bora.blackberry.domain.article.service;

import com.bora.blackberry.api.v1.article.form.ArticleForm;
import com.bora.blackberry.api.v1.common.exception.CommonException;
import com.bora.blackberry.domain.article.entity.Article;
import com.bora.blackberry.domain.article.repository.ArticleRepository;
import com.bora.blackberry.domain.constant.IsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getArticles(long boardId) {
        return articleRepository.findAllByBoardId(boardId);
    }

    public Article getDetailArticle(long articleId) {
        return articleRepository.findById(articleId);
    }

    @Transactional
    public long createArticle(long boardId, ArticleForm articleForm) {

        Article savedArticle = articleRepository.save(
            Article.builder().boardId(boardId)
                .title(articleForm.getTitle())
                .body(articleForm.getBody())
                .reported(IsType.N)
                .deleted(IsType.N)
                .build());

        return savedArticle.getId();
    }

    @Transactional
    public void updateArticle(long articleId, ArticleForm articleForm) {

        Article article = articleRepository.findById(articleId);
        if (article == null) {
            throw new CommonException("cannot find article with id: " + articleId);
        }

        article.setTitle(articleForm.getTitle());
        article.setBody(articleForm.getBody());
        article.setUpdatedAt(LocalDateTime.now());

        articleRepository.save(article);
    }

    @Transactional
    public void deleteArticle(long articleId) {
        Article article = articleRepository.findById(articleId);
        if (article == null) {
            throw new CommonException("cannot find article with id: " + articleId);
        }

        article.setDeleted(IsType.Y);
        articleRepository.save(article);
    }
}
