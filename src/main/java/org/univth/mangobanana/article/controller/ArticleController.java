package org.univth.mangobanana.article.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.univth.mangobanana.article.domain.Article;
import org.univth.mangobanana.article.service.ArticleService;

import javax.validation.Valid;

/**
 * Created by TaeHwan
 * 2017. 7. 24. PM 4:26
 */
@Controller @Slf4j
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/all")
    public String getArticleAll(Model article, Pageable pageable){
        article.addAttribute("articles",articleService.findByArticleTitle(pageable));
        return "/article/list";
    }

    @GetMapping("/{articleId}")
    public String getArticleId(
            @PathVariable(name = "articleId", required = false) Long articleId, Model article){
        log.info("여기까지는 온다");

        if(articleService.findByArticle(articleId) == null) {
            log.info("값이 없음");
            article.addAttribute("msg", "값이 없음");
        }
        else {
            log.info("값이 있음");
            article.addAttribute(articleService.findByArticle(articleId));

        }
        return "/article/details";
    }

    @PutMapping("/create")
    public String createArticle(Article article){
//        if (bindingResult.hasErrors()) {
//            return "index";
//        }
        log.info("들어옴");
        log.info(article.getArticleTitle());
        articleService.createArticle(article);
        return "/article/create";
    }
    @GetMapping("/create")
    public String createArticle(){
        return "/article/create";
    }
}
