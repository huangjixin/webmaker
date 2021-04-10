package com.hjx.webmaker.modules.core.web.admin;

import com.hjx.webmaker.modules.base.web.BaseController;
import com.hjx.webmaker.modules.core.domain.Channel;
import com.hjx.webmaker.modules.core.dto.ChannelDto;
import com.hjx.webmaker.modules.core.service.IChannelService;
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
import java.util.List;

@Controller
@RequestMapping("admin/channel")
public class ChannelController extends BaseController<Channel> {
    private static Logger logger = LoggerFactory.getLogger(ChannelController.class);
    private final static String prefix = "admin/core/channel";

    @Qualifier(value = "channelService")
    @Autowired
    private IChannelService channelService;


    @GetMapping
    public String index() {
        return prefix + "/channels";
    }

    @GetMapping("create")
    public String create(Model uiModel, ChannelDto channelDto, HttpServletRequest request, HttpServletResponse response) {
        List channels = this.channelService.getTree();
        channelDto.setChildren(channels);
        uiModel.addAttribute("channel", channelDto);
        return prefix + "/create";
    }

    @GetMapping("edit/{id}")
    public String edit(Model uiModel, @PathVariable("id") String id, ChannelDto channelDto, HttpServletRequest request, HttpServletResponse response) {
        Channel channel = this.channelService.selectByPrimaryKey(id);
        channelDto = (ChannelDto) channel;
        uiModel.addAttribute("channel", channelDto);
        return prefix + "/edit";
    }
}
