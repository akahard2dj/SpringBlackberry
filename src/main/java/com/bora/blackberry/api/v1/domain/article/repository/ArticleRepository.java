package com.bora.blackberry.api.v1.domain.article.repository;

import com.bora.blackberry.api.v1.domain.article.entity.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {

    List<Article> findAllByBoardId(long boardId);
    Article findById(long id);
}
