package org.univth.mangobanana.article.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by TaeHwan
 * 2017. 7. 24. PM 4:26
 */
@Entity @NoArgsConstructor @Data
public class Article{
    public Article(String articleTitle, String articleContent){
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;
    private String articleTitle;
    @Lob
    private String articleContent;
    private boolean articleSecret;
    private boolean articleDelete;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private Set<Reply> reply = new LinkedHashSet<>();

    public void addReply(Reply reply){
        this.reply.add(reply);
    }
}
