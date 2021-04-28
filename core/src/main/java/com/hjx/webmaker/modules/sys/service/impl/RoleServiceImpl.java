package com.hjx.webmaker.modules.sys.service.impl;

import com.hjx.webmaker.modules.base.mapper.BaseMapper;
import com.hjx.webmaker.modules.base.service.impl.BaseServiceImpl;
import com.hjx.webmaker.modules.base.utils.UUIDUtil;
import com.hjx.webmaker.modules.sys.domain.Role;
import com.hjx.webmaker.modules.sys.domain.RolePermission;
import com.hjx.webmaker.modules.sys.domain.RolePermissionCriteria;
import com.hjx.webmaker.modules.sys.dto.RoleDto;
import com.hjx.webmaker.modules.sys.mapper.PermissionMapper;
import com.hjx.webmaker.modules.sys.mapper.RoleMapper;
import com.hjx.webmaker.modules.sys.mapper.RolePermissionMapper;
import com.hjx.webmaker.modules.sys.service.IRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService {

    // ----- 缓存前缀
    private final static String KEY_PRE = "com.hjx.webmaker.modules.sys.service.impl.RoleServiceImpl:";

    private final static String BAES_MESSAGE = "【系统角色】日志-------------";

    private static Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    protected BaseMapper getBaseMapper() {
        return roleMapper;
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
     * 插入角色对象
     *
     * @param roleDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(RoleDto roleDto) {
        logger.info(this.getBaseMessage());
        if (roleDto.getId() == null) {
            roleDto.setId(UUIDUtil.generateUUID());
        }
        int result = super.insertSelective(roleDto);

        List<String> perIds = roleDto.getPermissionIds();
        List<RolePermission> rolePermissions = new ArrayList<>();
        for (String pId : perIds) {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setId(UUIDUtil.generateUUID());
            rolePermission.setRoleId(roleDto.getId());
            rolePermission.setPermissionId(pId);
            rolePermissions.add(rolePermission);
        }

        if(rolePermissions.size()>0){
            rolePermissionMapper.insertBatch(rolePermissions);
        }

        return result;
    }

    /**
     * 更新角色。
     *
     * @param roleDto
     * @return
     */
    @Override
    public int update(RoleDto roleDto) {
        logger.info(this.getBaseMessage());
        if (roleDto.getId() == null) {
            roleDto.setId(UUIDUtil.generateUUID());
        }
        int result = super.updateByPrimaryKeySelective(roleDto);

        // -------- 先删除再添加。
        RolePermissionCriteria rolePermissionCriteria = new RolePermissionCriteria();
        rolePermissionCriteria.createCriteria().andRoleIdEqualTo(roleDto.getId());
        rolePermissionMapper.deleteByExample(rolePermissionCriteria);

        List<String> perIds = roleDto.getPermissionIds();
        List<RolePermission> rolePermissions = new ArrayList<>();
        for (String pId : perIds) {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setId(UUIDUtil.generateUUID());
            rolePermission.setRoleId(roleDto.getId());
            rolePermission.setPermissionId(pId);
            rolePermissions.add(rolePermission);
        }

        if(rolePermissions.size()>0){
            rolePermissionMapper.insertBatch(rolePermissions);
        }

        return result;
    }
}
