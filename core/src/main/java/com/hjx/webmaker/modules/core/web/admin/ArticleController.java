package com.hjx.webmaker.modules.core.web.admin;

import com.hjx.webmaker.modules.base.web.BaseController;
import com.hjx.webmaker.modules.core.dto.ArticleDto;
import com.hjx.webmaker.modules.core.dto.ChannelDto;
import com.hjx.webmaker.modules.core.service.IArticleService;
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
@RequestMapping("admin/article")
public class ArticleController<Article> extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    private final static String prefix = "admin/core/article";

    @Qualifier(value = "articleService")
    @Autowired
    private IArticleService articleService;

    @GetMapping
    public String index() {
        return prefix + "/articles";
    }

    @GetMapping("create")
    public String create(Model uiModel, ArticleDto articleDto, ChannelDto channelDto, HttpServletRequest request, HttpServletResponse response) {
        uiModel.addAttribute("article", articleDto);
        uiModel.addAttribute("chanels", channelDto);
        return prefix + "/create";
    }

    @GetMapping("edit/{id}")
    public String edit(Model uiModel, @PathVariable("id") String id, ArticleDto articleDto, ChannelDto channelDto, HttpServletRequest request, HttpServletResponse response) {
//        articleDto = (ArticleDto) this.articleService.selectByPrimaryKey(id);
        uiModel.addAttribute("article", articleDto);
        uiModel.addAttribute("chanels", channelDto);
        return prefix + "/edit";
    }
}
