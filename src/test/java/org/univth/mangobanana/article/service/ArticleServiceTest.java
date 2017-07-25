package org.univth.mangobanana.article.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.univth.mangobanana.article.domain.Article;
import org.univth.mangobanana.article.domain.Reply;
import org.univth.mangobanana.article.repository.ArticleRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TaeHwan
 * 2017. 7. 25. AM 11:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceTest {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleService articleService;

    @After
    public void cleanAll(){
        articleRepository.deleteAll();
    }

    @Before
    public void setup(){
        List<Article> articles = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i ++){
            Article article = new Article("테스트"+String.valueOf(i),"컨텐츠"+String.valueOf(i));
            article.addReply(new Reply("테스트"+String.valueOf(i),"컨텐츠"+String.valueOf(i)));
            articles.add(article);
        }
        articleRepository.save(articles);
    }
}