package org.univth.mangobanana.article.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.univth.mangobanana.article.domain.Article;

/**
 * Created by TaeHwan
 * 2017. 7. 24. PM 4:28
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{
    Article findArticleByArticleId(long articleId);
    Page<Article> findAll(Pageable pageable);
    Page<Article> findByArticleTitle(String articleTitle, Pageable pageable);
}
