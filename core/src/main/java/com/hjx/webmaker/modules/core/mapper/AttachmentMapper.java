package com.hjx.webmaker.modules.core.mapper;

import com.hjx.webmaker.modules.core.domain.Attachment;
import com.hjx.webmaker.modules.core.domain.AttachmentCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttachmentMapper {
    long countByExample(AttachmentCriteria example);

    int deleteByExample(AttachmentCriteria example);

    int insert(Attachment record);

    int insertSelective(Attachment record);

    List<Attachment> selectByExample(AttachmentCriteria example);

    int updateByExampleSelective(@Param("record") Attachment record, @Param("example") AttachmentCriteria example);

    int updateByExample(@Param("record") Attachment record, @Param("example") AttachmentCriteria example);
}