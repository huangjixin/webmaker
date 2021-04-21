package com.hjx.webmaker.modules.sys.service;

import com.hjx.webmaker.modules.base.service.IBaseService;
import com.hjx.webmaker.modules.sys.domain.Permission;

import java.util.List;

public interface IPermissionService extends IBaseService<Permission> {

    /**
     * 查询树
     *
     * @param parentId
     * @param roleId
     * @return
     */
    List getTree(String parentId, String roleId);
}
