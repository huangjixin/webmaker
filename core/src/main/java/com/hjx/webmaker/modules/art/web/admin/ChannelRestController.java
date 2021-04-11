package com.hjx.webmaker.modules.art.web.admin;

import com.hjx.webmaker.modules.base.web.BaseRestController;
import com.hjx.webmaker.modules.art.domain.Channel;
import com.hjx.webmaker.modules.art.service.IChannelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("admin/art/channel")
public class ChannelRestController extends BaseRestController<Channel> {
    private static Logger logger = LoggerFactory.getLogger(ChannelRestController.class);

    @Qualifier(value = "channelService")
    @Autowired
    private IChannelService channelService;

    @GetMapping("tree")
    public List tree(@RequestParam(name = "parentId", required = false) Long parentId,
                     @RequestParam(name = "channelId", required = false) Long channelId,
                                    HttpServletRequest request, HttpServletResponse response) {

        List list = this.channelService.getTree(parentId,channelId);
        return list;
    }
}
