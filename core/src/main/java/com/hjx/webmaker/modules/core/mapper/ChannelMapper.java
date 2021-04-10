package com.hjx.webmaker.modules.core.mapper;

import com.hjx.webmaker.modules.core.domain.Channel;
import com.hjx.webmaker.modules.core.domain.ChannelCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChannelMapper {
    long countByExample(ChannelCriteria example);

    int deleteByExample(ChannelCriteria example);

    int insert(Channel record);

    int insertSelective(Channel record);

    List<Channel> selectByExample(ChannelCriteria example);

    int updateByExampleSelective(@Param("record") Channel record, @Param("example") ChannelCriteria example);

    int updateByExample(@Param("record") Channel record, @Param("example") ChannelCriteria example);
}