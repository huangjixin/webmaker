package com.hjx.webmaker.modules.core.service;

import com.hjx.webmaker.CoreApplication;
import com.hjx.webmaker.modules.core.domain.Channel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CoreApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IChannelServiceTest {
    @Qualifier(value = "channelService")
    @Autowired
    private IChannelService channelService;

    @Test
    public void testInsert(){
        Channel channel = new Channel();
        int result = channelService.insert(channel);
        System.out.println(channel.getId());
    }
}