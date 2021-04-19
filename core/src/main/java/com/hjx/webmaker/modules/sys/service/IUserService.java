package com.hjx.webmaker.modules.sys.service;

import com.hjx.webmaker.modules.base.service.IBaseService;
import com.hjx.webmaker.modules.sys.domain.User;
import com.hjx.webmaker.modules.sys.dto.UserDto;

public interface IUserService extends IBaseService<User> {
    /**
     * 根据用户名（邮箱，电话）查询对象。
     * @param loginName
     * @return
     */
    UserDto selectByUserName(String loginName);

    /**
     * 新增用户
     * @param record
     * @return
     */
    int insert(UserDto record);

    /**
     * 更新用户
     * @param record
     * @return
     */
    int update(UserDto record);
}
