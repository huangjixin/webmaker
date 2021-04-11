package com.hjx.webmaker.modules.art.web.admin;

import com.hjx.webmaker.modules.art.domain.Channel;
import com.hjx.webmaker.modules.art.dto.ChannelDto;
import com.hjx.webmaker.modules.art.service.IChannelService;
import com.hjx.webmaker.modules.base.web.BaseController;
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
@RequestMapping("admin/art/channel")
public class ChannelController extends BaseController<Channel> {
    private static Logger logger = LoggerFactory.getLogger(ChannelController.class);
    private final static String prefix = "admin/art/channel";

    @Qualifier(value = "channelService")
    @Autowired
    private IChannelService channelService;


    @GetMapping
    public String index() {
        return prefix + "/channels";
    }

    @GetMapping("create")
    public String create(Model uiModel, ChannelDto channelDto, HttpServletRequest request, HttpServletResponse response) {
//        List channels = this.channelService.getTree(null);
//        channelDto.setChildren(channels);
        uiModel.addAttribute("channel", channelDto);
        return prefix + "/create";
    }

    @GetMapping("edit/{id}")
    public String edit(Model uiModel, @PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) {
        Channel channel = this.channelService.selectByPrimaryKey(id);

        uiModel.addAttribute("channel", channel);
        return prefix + "/edit";
    }

    @PostMapping
    public String create(Model uiModel, @ModelAttribute @Validated ChannelDto channelDto, BindingResult bindingResult, RedirectAttributes attributes, HttpServletRequest request, HttpServletResponse response) {
        //-------------- 前端错误显示
        /*<span th:if="${#fields.hasErrors('user.username')}" th:errors="${user.username}"></span>*/

        // 如果有参数校验失败，会将错误信息封装成对象组装在BindingResult里
        uiModel.addAttribute("channel", channelDto);

        if (bindingResult.hasErrors()) {
            return prefix + "/create";
        }
        if (null == channelDto.getParentId() || "".equals(channelDto.getParentId())) {
            channelDto.setParentId(Long.valueOf(0));
        }
        channelDto.setCreatedTime(new Date());
        this.channelService.insert(channelDto);
        attributes.addAttribute("msg", "执行成功");
        return "redirect:/" + prefix + "/create";
    }

    @PostMapping("edit/{id}")
    public String edit(Model uiModel, @PathVariable("id") Long id, Channel channel, HttpServletRequest request, HttpServletResponse response) {
        Channel chan = this.channelService.selectByPrimaryKey(id);

        channel.setUpdateTime(new Date());
        this.channelService.updateByPrimaryKeySelective(channel);
        uiModel.addAttribute("channel", channel);
        return prefix + "/edit";
    }
}
