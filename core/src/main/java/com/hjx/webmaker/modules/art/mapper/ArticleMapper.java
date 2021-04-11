package com.hjx.webmaker.modules.art.mapper;

import com.hjx.webmaker.modules.base.mapper.BaseMapper;
import com.hjx.webmaker.modules.art.domain.Article;
import com.hjx.webmaker.modules.art.domain.ArticleCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper extends BaseMapper<Article> {
    List<Article> selectByExampleWithBLOBs(ArticleCriteria example);

    int updateByExampleWithBLOBs(@Param("record") Article record, @Param("example") ArticleCriteria example);

    int updateByPrimaryKeyWithBLOBs(Article record);
}