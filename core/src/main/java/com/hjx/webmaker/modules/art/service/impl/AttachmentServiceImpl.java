package com.hjx.webmaker.modules.art.service.impl;

import com.hjx.webmaker.modules.base.mapper.BaseMapper;
import com.hjx.webmaker.modules.base.service.impl.BaseServiceImpl;
import com.hjx.webmaker.modules.art.domain.Attachment;
import com.hjx.webmaker.modules.art.mapper.AttachmentMapper;
import com.hjx.webmaker.modules.art.service.IAttachmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "attachmentService")
public class AttachmentServiceImpl extends BaseServiceImpl<Attachment> implements IAttachmentService {
    // ----- 缓存前缀
    private final static String KEY_PRE = "com.hjx.webmaker.modules.core.service.impl.AttachmentServiceImpl:";

    private final static String BAES_MESSAGE = "【附件】日志-------------";

    private static Logger logger = LoggerFactory.getLogger(AttachmentServiceImpl.class);

    @Autowired
    private AttachmentMapper attachmentMapper;

    @Override
    protected BaseMapper getBaseMapper() {
        return attachmentMapper;
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
}
