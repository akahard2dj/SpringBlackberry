package com.bora.blackberry.api.v1.domain.article.service;

import com.bora.blackberry.api.v1.article.form.ArticleForm;
import com.bora.blackberry.api.v1.domain.article.entity.Article;
import com.bora.blackberry.api.v1.domain.article.repository.ArticleRepository;
import com.bora.blackberry.api.v1.domain.constant.IsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getArticles(long boardId) {
        return articleRepository.findAllByBoardId(boardId);
    }

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
}
