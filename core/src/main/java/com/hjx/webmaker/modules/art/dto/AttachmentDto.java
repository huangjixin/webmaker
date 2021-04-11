package com.hjx.webmaker.modules.art.dto;

import com.hjx.webmaker.modules.art.domain.Article;
import com.hjx.webmaker.modules.art.domain.Attachment;

public class AttachmentDto extends Attachment {
    private Article article = new Article();

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
