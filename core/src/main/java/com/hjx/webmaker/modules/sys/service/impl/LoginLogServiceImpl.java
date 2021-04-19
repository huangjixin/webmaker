package com.hjx.webmaker.modules.sys.service.impl;

import com.hjx.webmaker.modules.base.mapper.BaseMapper;
import com.hjx.webmaker.modules.base.service.impl.BaseServiceImpl;
import com.hjx.webmaker.modules.sys.domain.LoginLog;
import com.hjx.webmaker.modules.sys.mapper.LoginLogMapper;
import com.hjx.webmaker.modules.sys.service.ILoginLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginLogService")
public class LoginLogServiceImpl extends BaseServiceImpl<LoginLog> implements ILoginLogService {

    // ----- 缓存前缀
    private final static String KEY_PRE = "com.hjx.webmaker.modules.sys.service.impl.LoginLogServiceImpl:";

    private final static String BAES_MESSAGE = "【系统权限】日志-------------";

    private static Logger logger = LoggerFactory.getLogger(LoginLogServiceImpl.class);

    @Autowired
    private LoginLogMapper loginLogMapper;

    @Override
    protected BaseMapper getBaseMapper() {
        return loginLogMapper;
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
