package com.hjx.webmaker.modules.art.service.impl;

import com.hjx.webmaker.modules.art.domain.Article;
import com.hjx.webmaker.modules.art.domain.ArticleCriteria;
import com.hjx.webmaker.modules.art.dto.ArticleDto;
import com.hjx.webmaker.modules.art.mapper.ArticleMapper;
import com.hjx.webmaker.modules.art.service.IArticleService;
import com.hjx.webmaker.modules.base.mapper.BaseMapper;
import com.hjx.webmaker.modules.base.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Service(value = "articleService")
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements IArticleService {
    // ----- 缓存前缀
    private final static String KEY_PRE = "com.hjx.webmaker.modules.core.service.impl.ArticleServiceImpl:";

    private final static String BAES_MESSAGE = "【文章】日志-------------";

    private static Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    protected BaseMapper getBaseMapper() {
        return articleMapper;
    }

    @Override
    protected String getBaseMessage() {
        return BAES_MESSAGE;
    }

    @Override
    protected String getKeyPre() {
        return KEY_PRE;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Override
    public List<Article> selectByExampleWithBLOBs(ArticleCriteria example) {
        return this.articleMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public int updateByExampleWithBLOBs(Article record, ArticleCriteria example) {
        return this.articleMapper.updateByExampleWithBLOBs(record, example);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Article record) {
        String content = record.getContent();
        if(!StringUtils.isEmpty(content)){
            content = HtmlUtils.htmlEscape(content);
        }
        record.setContent(content);

        return this.articleMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public ArticleDto selectByPrimaryKey(Object id){
        ArticleDto record = this.articleMapper.selectByPrimaryKey(id);
        String content = record.getContent();
        if(!StringUtils.isEmpty(content)){
            content = HtmlUtils.htmlUnescape(content);
        }
        record.setContent(content);
        return record;
    }


    @Override
    public int insert(Article record) {
        String content = record.getContent();
        if(!StringUtils.isEmpty(content)){
            content = HtmlUtils.htmlEscape(content);
        }
        record.setContent(content);

        int result = getBaseMapper().insert(record);
        return result;
    }

    @Override
    public int insertSelective(Article record) {
        String content = record.getContent();
        if(!StringUtils.isEmpty(content)){
            content = HtmlUtils.htmlEscape(content);
        }
        record.setContent(content);
        int result = getBaseMapper().insertSelective(record);
        return result;
    }

}
