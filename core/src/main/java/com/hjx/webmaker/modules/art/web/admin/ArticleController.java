package com.hjx.webmaker.modules.art.web.admin;

import com.hjx.webmaker.modules.base.web.BaseController;
import com.hjx.webmaker.modules.art.domain.Article;
import com.hjx.webmaker.modules.art.dto.ArticleDto;
import com.hjx.webmaker.modules.art.dto.ChannelDto;
import com.hjx.webmaker.modules.art.service.IArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("admin/art/article")
public class ArticleController extends BaseController<Article> {

    private static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    private final static String prefix = "admin/art/article";

    @Qualifier(value = "articleService")
    @Autowired
    private IArticleService articleService;

    @GetMapping
    public String index() {
        return prefix + "/articles";
    }

    @GetMapping("create")
    public String create(Model uiModel, ArticleDto articleDto, HttpServletRequest request, HttpServletResponse response) {
        uiModel.addAttribute("article", articleDto);
        return prefix + "/create";
    }

    @GetMapping("edit/{id}")
    public String edit(Model uiModel, @PathVariable("id") Long id,  HttpServletRequest request, HttpServletResponse response) {
        ArticleDto articleDto = (ArticleDto) this.articleService.selectByPrimaryKey(id);
        uiModel.addAttribute("article", articleDto);
        return prefix + "/edit";
    }
}
