package com.hjx.webmaker.modules.core.web.admin;

import com.hjx.webmaker.modules.base.web.BaseController;
import com.hjx.webmaker.modules.core.domain.Attachment;
import com.hjx.webmaker.modules.core.dto.ArticleDto;
import com.hjx.webmaker.modules.core.dto.AttachmentDto;
import com.hjx.webmaker.modules.core.service.IAttachmentService;
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
@RequestMapping("admin/attachment")
public class AttachmentController extends BaseController<Attachment> {
    private static Logger logger = LoggerFactory.getLogger(AttachmentController.class);
    private final static String prefix = "admin/core/attachment";

    @Qualifier(value = "attachmentService")
    @Autowired
    private IAttachmentService attachmentService;


    @GetMapping
    public String index() {
        return prefix + "/attachments";
    }

    @GetMapping("create")
    public String create(Model uiModel, ArticleDto articleDto, AttachmentDto attachmentDto, HttpServletRequest request, HttpServletResponse response) {
        uiModel.addAttribute("article", articleDto);
        uiModel.addAttribute("attachment", attachmentDto);
        return prefix + "/create";
    }

    @GetMapping("edit/{id}")
    public String edit(Model uiModel, @PathVariable("id") String id, ArticleDto articleDto, AttachmentDto attachmentDto, HttpServletRequest request, HttpServletResponse response) {
        uiModel.addAttribute("article", articleDto);
        uiModel.addAttribute("attachment", attachmentDto);
        return prefix + "/edit";
    }
}
