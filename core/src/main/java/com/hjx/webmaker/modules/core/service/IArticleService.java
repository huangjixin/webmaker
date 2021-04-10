package com.hjx.webmaker.modules.core.service;

import com.hjx.webmaker.modules.base.service.IBaseService;
import com.hjx.webmaker.modules.core.domain.Article;
import com.hjx.webmaker.modules.core.domain.ArticleCriteria;
import com.hjx.webmaker.modules.core.domain.Channel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IArticleService extends IBaseService<Article> {
    List<Article> selectByExampleWithBLOBs(ArticleCriteria example);

    int updateByExampleWithBLOBs(@Param("record") Article record, @Param("example") ArticleCriteria example);

    int updateByPrimaryKeyWithBLOBs(Article record);
}
