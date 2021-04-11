package com.hjx.webmaker.modules.art.web.admin;

import com.hjx.webmaker.modules.base.web.BaseRestController;
import com.hjx.webmaker.modules.art.domain.Article;
import com.hjx.webmaker.modules.art.service.IArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/art/article")
public class ArticleRestController extends BaseRestController<Article> {
    private static Logger logger = LoggerFactory.getLogger(ArticleRestController.class);

    @Qualifier(value = "articleService")
    @Autowired
    private IArticleService articleService;
}
