package org.univth.mangobanana.article.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by TaeHwan
 * 2017. 7. 25. AM 11:38
 */
@Entity @NoArgsConstructor @Data
public class Reply {
    public Reply(String replyAuthor, String replyContent){
        this.replyAuthor = replyAuthor;
        this.replyContent = replyContent;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyId;
    private String replyAuthor;
    @Lob
    private String replyContent;
    private boolean replySecret;
    private boolean replyDelete;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Article article;
}