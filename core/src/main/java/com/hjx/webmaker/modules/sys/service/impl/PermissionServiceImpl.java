package com.hjx.webmaker.modules.sys.service.impl;

import com.hjx.webmaker.modules.base.mapper.BaseMapper;
import com.hjx.webmaker.modules.base.service.impl.BaseServiceImpl;
import com.hjx.webmaker.modules.base.utils.TreeHelper;
import com.hjx.webmaker.modules.sys.domain.Permission;
import com.hjx.webmaker.modules.sys.dto.RoleDto;
import com.hjx.webmaker.modules.sys.mapper.PermissionMapper;
import com.hjx.webmaker.modules.sys.mapper.RoleMapper;
import com.hjx.webmaker.modules.sys.service.IPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 *
 */
@Service("permissionService")
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements IPermissionService {

    // ----- 缓存前缀
    private final static String KEY_PRE = "com.hjx.webmaker.modules.sys.service.impl.PermissionServiceImpl:";

    private final static String BAES_MESSAGE = "【系统权限】日志-------------";

    private static Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    protected BaseMapper getBaseMapper() {
        return permissionMapper;
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
    public List getTree(String parentId, String roleId) {
        logger.info(getBaseMessage() + "查询权限树数据getTree开始，参数分别是parentId:" + parentId + ",roleId:" + roleId);
        List list = this.selectByExample(null);

        //------------------- 将父类ID设置为选中
        if (!StringUtils.isEmpty(parentId)) {
            if (!StringUtils.isEmpty(list)) {
                logger.info(getBaseMessage() + "参数parentId:" + parentId + "不为空，遍历列表获取该父类ID所在数据项，设置数据属性开始");

                Permission sysPermission = null;
                for (int i = 0; i < list.size(); i++) {
                    sysPermission = (Permission) list.get(i);
                    if (sysPermission.getId().equals(parentId)) {
                        sysPermission.getState().setChecked(true);
                        sysPermission.getState().setSelected(true);
                        sysPermission.getState().setExpanded(true);
                        break;
                    }
                }

                logger.info(getBaseMessage() + "参数parentId:" + parentId + "不为空，遍历列表获取该父类ID所在数据项，设置数据属性结束，sysPermission为：" + sysPermission.toString());
            }
        }

        //------------------- 将父类ID设置为选中
        if (!StringUtils.isEmpty(roleId)) {
            if (!StringUtils.isEmpty(list)) {
                RoleDto roleDto = roleMapper.selectByPrimaryKeyWithPermissions(roleId);
                if (roleDto != null) {
                    List<Permission> list2 = roleDto.getPermissions();
                    logger.info(getBaseMessage() + "roleId:" + roleId + "不为空，查询角色对应的列表，两次循环遍历列表，设置数据属性开始");
                    for (int i = 0; i < list.size(); i++) {
                        Permission sysPermission = (Permission) list.get(i);

                        for (int j = 0; j < list2.size(); j++) {
                            Permission sysPermission2 = list2.get(j);
                            if (sysPermission.getId().equals(sysPermission2.getId())) {
                                sysPermission.getState().setChecked(true);
                                sysPermission.getState().setSelected(true);
//                               sysPermission.getState().setExpanded(false);
                            }
                        }
                    }
                    logger.info(getBaseMessage() + "roleId:" + roleId + "不为空，查询角色对应的列表，两次循环遍历列表，设置数据属性结束");
                }
            }
        }

        list = TreeHelper.getTreeNodes(list);

        logger.info(getBaseMessage() + "查询权限树数据getTree结束，结果为:" + (list.size() > 0 ? ("条目数：【" + list.size() + "】,字符串：" + list.toString()) : "数据为空"));
        return list;
    }
}
