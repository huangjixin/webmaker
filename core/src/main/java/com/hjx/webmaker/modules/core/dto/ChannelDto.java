package com.hjx.webmaker.modules.core.dto;

import com.hjx.webmaker.modules.core.domain.Article;
import com.hjx.webmaker.modules.core.domain.Channel;

import java.util.List;

public class ChannelDto extends Channel {

    private List<Channel> channels;
    private List<Article> articles;


    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }


}
