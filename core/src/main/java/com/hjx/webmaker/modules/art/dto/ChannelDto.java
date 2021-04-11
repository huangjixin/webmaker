package com.hjx.webmaker.modules.art.dto;

import com.hjx.webmaker.modules.art.domain.Article;
import com.hjx.webmaker.modules.art.domain.Channel;

import java.util.ArrayList;
import java.util.List;

public class ChannelDto extends Channel {

    private List<Channel> channels = new ArrayList<>();
    private List<Article> articles = new ArrayList<>();

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
