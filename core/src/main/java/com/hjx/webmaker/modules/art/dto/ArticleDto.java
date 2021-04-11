package com.hjx.webmaker.modules.art.dto;

import com.hjx.webmaker.modules.art.domain.Article;
import com.hjx.webmaker.modules.art.domain.Attachment;
import com.hjx.webmaker.modules.art.domain.Channel;

import java.util.List;

public class ArticleDto extends Article {
    private Channel channel;
    private List<Attachment> attachments;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        String parStr = super.toString();
        return "ArticleDto{" +
                "channel=" + channel.toString() +
                ", attachments=" + attachments +
                parStr.toString()+
                '}';
    }
}
