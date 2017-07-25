package org.univth.mangobanana.article.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.univth.mangobanana.article.domain.Article;
import org.univth.mangobanana.article.repository.ArticleRepository;

import java.util.List;

/**
 * Created by TaeHwan
 * 2017. 7. 24. PM 4:30
 */
@Service @Slf4j
public class ArticleService{
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article findByArticle(long articleId){
        return articleRepository.findOne(articleId);
    }

    public List<Article> findAllArticle(){
        return articleRepository.findAll();
    }

    public void createArticle(Article article){
        log.info("Created By : {}", article.getArticleTitle());
        articleRepository.save(article);
    }

    public Page<Article> findByArticleTitle(String articleTitle, Pageable page){
        return articleRepository.findByArticleTitle(articleTitle, page);
    }
}
