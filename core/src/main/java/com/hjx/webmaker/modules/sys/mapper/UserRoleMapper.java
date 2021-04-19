package com.hjx.webmaker.modules.sys.mapper;

import com.hjx.webmaker.modules.base.mapper.BaseMapper;
import com.hjx.webmaker.modules.sys.domain.RolePermission;
import com.hjx.webmaker.modules.sys.domain.UserRole;
import com.hjx.webmaker.modules.sys.domain.UserRoleCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleMapper  extends BaseMapper<UserRole> {
    int insertBatch(@Param("userRoles") List<UserRole> userRoles);
    /*long countByExample(UserRoleCriteria example);

    int deleteByExample(UserRoleCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    List<UserRole> selectByExample(UserRoleCriteria example);

    UserRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserRole record, @Param("example") UserRoleCriteria example);

    int updateByExample(@Param("record") UserRole record, @Param("example") UserRoleCriteria example);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);*/
}