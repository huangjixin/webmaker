package com.hjx.webmaker.modules.core.mapper;

import com.hjx.webmaker.modules.core.domain.Article;
import com.hjx.webmaker.modules.core.domain.ArticleCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {
    long countByExample(ArticleCriteria example);

    int deleteByExample(ArticleCriteria example);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExampleWithBLOBs(ArticleCriteria example);

    List<Article> selectByExample(ArticleCriteria example);

    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleCriteria example);

    int updateByExampleWithBLOBs(@Param("record") Article record, @Param("example") ArticleCriteria example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleCriteria example);
}