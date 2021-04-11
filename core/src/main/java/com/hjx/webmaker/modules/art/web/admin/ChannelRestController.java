package com.hjx.webmaker.modules.art.web.admin;

import com.hjx.webmaker.modules.base.web.BaseRestController;
import com.hjx.webmaker.modules.art.domain.Channel;
import com.hjx.webmaker.modules.art.service.IChannelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/art/channel")
public class ChannelRestController extends BaseRestController<Channel> {
    private static Logger logger = LoggerFactory.getLogger(ChannelRestController.class);

    @Qualifier(value = "channelService")
    @Autowired
    private IChannelService channelService;
}
