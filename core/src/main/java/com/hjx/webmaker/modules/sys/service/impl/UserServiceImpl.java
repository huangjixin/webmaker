package com.hjx.webmaker.modules.sys.service.impl;

import com.hjx.webmaker.modules.base.mapper.BaseMapper;
import com.hjx.webmaker.modules.base.service.impl.BaseServiceImpl;
import com.hjx.webmaker.modules.base.utils.TreeHelper;
import com.hjx.webmaker.modules.base.utils.vo.Node;
import com.hjx.webmaker.modules.sys.domain.Permission;
import com.hjx.webmaker.modules.sys.domain.User;
import com.hjx.webmaker.modules.sys.dto.UserDto;
import com.hjx.webmaker.modules.sys.mapper.UserMapper;
import com.hjx.webmaker.modules.sys.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService, UserDetailsService {

    // ----- 缓存前缀
    private final static String KEY_PRE = "com.hjx.webmaker.modules.sys.service.impl.UserServiceImpl:";

    private final static String BAES_MESSAGE = "【系统用户】日志-------------";

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    protected BaseMapper getBaseMapper() {
        return userMapper;
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
     * 根据用户名（邮箱，电话）查询对象。
     *
     * @param loginName
     * @return
     */
    @Override
    public UserDto selectByUserName(String loginName) {
        return this.userMapper.selectByUserName(loginName);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("认证开始，登录名：{}", username);
        UserDto user = this.selectByUserName(username);
        List<Permission> permissions = user.getPermissions();
        if (permissions != null && permissions.size() > 0) {
            List<Node> list =  TreeHelper.getTreeNodes(permissions);
            user.setTreePermissions(list);
        }
        logger.info("认证结束，结果为：{}", user == null ? "查不到结果" : user.toString());
        return user;
    }
}
