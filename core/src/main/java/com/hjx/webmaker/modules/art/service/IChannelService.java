package com.hjx.webmaker.modules.art.service;

import com.hjx.webmaker.modules.base.service.IBaseService;
import com.hjx.webmaker.modules.art.domain.Channel;

import java.util.List;

public interface IChannelService extends IBaseService<Channel> {
    /**
     * 打成树结构。
     *
     * @return
     */
    List<Channel> getTree(Long parentId);
}
