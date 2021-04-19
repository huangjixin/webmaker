package com.hjx.webmaker.modules.sys.mapper;

import com.hjx.webmaker.modules.base.mapper.BaseMapper;
import com.hjx.webmaker.modules.sys.domain.User;
import com.hjx.webmaker.modules.sys.dto.UserDto;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {
    UserDto selectByUserName(@Param("loginName") String loginName);

    /*long countByExample(UserCriteria example);

    int deleteByExample(UserCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserCriteria example);

    User selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserCriteria example);

    int updateByExample(@Param("record") User record, @Param("example") UserCriteria example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);*/
}