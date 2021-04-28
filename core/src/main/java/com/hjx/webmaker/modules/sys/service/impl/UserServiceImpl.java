package com.hjx.webmaker.modules.sys.service.impl;

import com.hjx.webmaker.modules.base.mapper.BaseMapper;
import com.hjx.webmaker.modules.base.service.impl.BaseServiceImpl;
import com.hjx.webmaker.modules.base.utils.MD5Tool;
import com.hjx.webmaker.modules.base.utils.TreeHelper;
import com.hjx.webmaker.modules.base.utils.UUIDUtil;
import com.hjx.webmaker.modules.base.utils.vo.Node;
import com.hjx.webmaker.modules.sys.domain.Permission;
import com.hjx.webmaker.modules.sys.domain.User;
import com.hjx.webmaker.modules.sys.domain.UserRole;
import com.hjx.webmaker.modules.sys.domain.UserRoleCriteria;
import com.hjx.webmaker.modules.sys.dto.UserDto;
import com.hjx.webmaker.modules.sys.mapper.UserMapper;
import com.hjx.webmaker.modules.sys.mapper.UserRoleMapper;
import com.hjx.webmaker.modules.sys.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private UserRoleMapper userRoleMapper;

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

    @Override
    public UserDto selectByPrimaryKey(Object id){
        return this.userMapper.selectByPrimaryKey(id);
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

    /**
     * 新增用户
     *
     * @param userDto
     * @return
     */
    @Override
    public int insert(UserDto userDto) {
        logger.info(this.getBaseMessage());
        if (userDto.getId() == null) {
            userDto.setId(UUIDUtil.generateUUID());
        }
        String pwd = userDto.getPassword();
        if (pwd == null) {
            pwd = "123456";
        }
        pwd = MD5Tool.MD5(pwd);
//        pwd = Md5Crypt.md5Crypt(pwd.getBytes());
        userDto.setPassword(pwd);
        userDto.setId(UUIDUtil.generateUUID());
        int result = super.insertSelective(userDto);

        // 关联用户角色中间表，为用户赋予角色。
        List<String> roleIds = userDto.getRoleIds();
        List<UserRole> userRoles = new ArrayList<UserRole>();
        for (String roleId : roleIds) {
            UserRole userRole = new UserRole();
            userRole.setId(UUIDUtil.generateUUID());
            userRole.setUserId(userDto.getId());
            userRole.setRoleId(roleId);
            userRoles.add(userRole);
        }

        if (userRoles.size() > 0) {
            this.userRoleMapper.insertBatch(userRoles);
        }

        return result;
    }

    /**
     * 更新用户
     *
     * @param userDto
     * @return
     */
    @Override
    public int update(UserDto userDto) {
        userDto.setPassword(null);
        int result = super.updateByPrimaryKeySelective(userDto);

        // 更新中间表的时候，先删除原先的关联表再重新插进去；
        UserRoleCriteria userRoleCriteria = new UserRoleCriteria();
        userRoleCriteria.createCriteria().andUserIdEqualTo(userDto.getId());
        this.userRoleMapper.deleteByExample(userRoleCriteria);

        // 关联用户角色中间表，为用户赋予角色。
        List<String> roleIds = userDto.getRoleIds();
        List<UserRole> userRoles = new ArrayList<UserRole>();
        for (String roleId : roleIds) {
            UserRole userRole = new UserRole();
            userRole.setId(UUIDUtil.generateUUID());
            userRole.setUserId(userDto.getId());
            userRole.setRoleId(roleId);
            userRoles.add(userRole);
        }

        if (userRoles.size() > 0) {
            this.userRoleMapper.insertBatch(userRoles);
        }
        return result;
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
