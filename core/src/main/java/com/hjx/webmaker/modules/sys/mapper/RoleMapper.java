package com.hjx.webmaker.modules.sys.mapper;

import com.hjx.webmaker.modules.base.mapper.BaseMapper;
import com.hjx.webmaker.modules.sys.domain.Role;
import com.hjx.webmaker.modules.sys.dto.RoleDto;

public interface RoleMapper extends BaseMapper<Role> {

    @Override
    RoleDto selectByPrimaryKey(Object id);
    /**
     * 根据ID查询带有权限的角色。
     * @param roleId
     * @return
     */
    RoleDto selectByPrimaryKeyWithPermissions(String roleId);

    /*long countByExample(RoleCriteria example);

    int deleteByExample(RoleCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleCriteria example);

    Role selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleCriteria example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleCriteria example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);*/
}