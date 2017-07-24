package org.univth.mangobanana.article.domain;

import javax.persistence.*;

/**
 * Created by TaeHwan
 * 2017. 7. 24. PM 4:26
 */
@Entity
public class Article{
    @Id
    private Long articleId;
    private String articleTitle;
    private String articleContent;

    public String getArticleTitle(){
        return this.articleTitle;
    }
}
