package com.hjx.webmaker.modules.sys.service;

import com.hjx.webmaker.modules.base.service.IBaseService;
import com.hjx.webmaker.modules.sys.domain.Role;
import com.hjx.webmaker.modules.sys.dto.RoleDto;
import com.hjx.webmaker.modules.sys.dto.UserDto;

public interface IRoleService extends IBaseService<Role> {
    /**
     * 插入角色对象
     * @param roleDto
     * @return
     */
    int insert(RoleDto roleDto);

    /**
     * 更新角色。
     * @param roleDto
     * @return
     */
    int update(RoleDto roleDto);
}
