package com.hjx.webmaker.modules.art.service.impl;

import com.hjx.webmaker.modules.base.mapper.BaseMapper;
import com.hjx.webmaker.modules.base.service.impl.BaseServiceImpl;
import com.hjx.webmaker.modules.base.utils.TreeHelper;
import com.hjx.webmaker.modules.art.domain.Channel;
import com.hjx.webmaker.modules.art.mapper.ChannelMapper;
import com.hjx.webmaker.modules.art.service.IChannelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "channelService")
public class ChannelServiceImpl extends BaseServiceImpl<Channel> implements IChannelService {
    // ----- 缓存前缀
    private final static String KEY_PRE = "com.hjx.webmaker.modules.core.service.impl.ChannelServiceImpl:";

    private final static String BAES_MESSAGE = "【频道】日志-------------";

    private static Logger logger = LoggerFactory.getLogger(ChannelServiceImpl.class);

    @Autowired
    private ChannelMapper channelMapper;

    @Override
    protected BaseMapper getBaseMapper() {
        return channelMapper;
    }

    @Override
    protected String getBaseMessage() {
        return BAES_MESSAGE;
    }

    @Override
    protected String getKeyPre() {
        return KEY_PRE;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }


    /**
     * 打成树结构。
     *
     * @return
     */
    @Override
    public List<Channel> getTree() {
        List list = this.channelMapper.selectByExample(null);
        list = TreeHelper.getTreeNodes(list);
        return list;
    }
}
