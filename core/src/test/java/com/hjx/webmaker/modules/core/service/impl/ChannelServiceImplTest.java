package com.hjx.webmaker.modules.core.service.impl;

import com.hjx.webmaker.CoreApplication;
import com.hjx.webmaker.modules.core.domain.Channel;
import com.hjx.webmaker.modules.core.service.IChannelService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CoreApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ChannelServiceImplTest {
    @Qualifier(value = "channelService")
    @Autowired
    private IChannelService channelService;

    @Test
    void getTree() {
        List<Channel> list = this.channelService.getTree();
        System.out.println(list.toString());
    }
}