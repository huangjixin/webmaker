package com.hjx.webmaker.modules.core.dto;

import com.hjx.webmaker.modules.core.domain.Article;
import com.hjx.webmaker.modules.core.domain.Attachment;

public class AttachmentDto extends Attachment {
    private Article article;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
