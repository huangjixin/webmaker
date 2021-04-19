package com.hjx.webmaker.modules.art.service;

import com.hjx.webmaker.modules.art.domain.Article;
import com.hjx.webmaker.modules.art.domain.ArticleCriteria;
import com.hjx.webmaker.modules.art.dto.ArticleDto;
import com.hjx.webmaker.modules.base.service.IBaseService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IArticleService extends IBaseService<Article> {
    int insert(ArticleDto record);
    int insertSelective(ArticleDto record);
    @Override
    ArticleDto selectByPrimaryKey(Object id);

    List<Article> selectByExampleWithBLOBs(ArticleCriteria example);

    int updateByExampleWithBLOBs(@Param("record") Article record, @Param("example") ArticleCriteria example);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKeyWithBLOBs(ArticleDto record);
}
