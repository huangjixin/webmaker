package com.hjx.webmaker.modules.art.web.admin;

import com.hjx.webmaker.modules.art.domain.Channel;
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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

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

    @PostMapping
    public String create(Model uiModel, @ModelAttribute @Validated ArticleDto articleDto, BindingResult bindingResult, RedirectAttributes attributes, HttpServletRequest request, HttpServletResponse response) {
        //-------------- 前端错误显示
        /*<span th:if="${#fields.hasErrors('user.username')}" th:errors="${user.username}"></span>*/

        // 如果有参数校验失败，会将错误信息封装成对象组装在BindingResult里
        uiModel.addAttribute("article", articleDto);

        if (bindingResult.hasErrors()) {
            return prefix + "/create";
        }

        articleDto.setCreatedTime(new Date());
        this.articleService.insert(articleDto);
        attributes.addAttribute("msg", "执行成功");
        return "redirect:/" + prefix + "/create";
    }

    @PostMapping("edit/{id}")
    public String edit(Model uiModel, @PathVariable("id") Long id, ArticleDto articleDto, HttpServletRequest request, HttpServletResponse response) {
        ArticleDto chan = this.articleService.selectByPrimaryKey(id);

        articleDto.setUpdateTime(new Date());
        int result = this.articleService.updateByPrimaryKeySelective(articleDto);
        uiModel.addAttribute("article", articleDto);
        return prefix + "/edit";
    }
}
