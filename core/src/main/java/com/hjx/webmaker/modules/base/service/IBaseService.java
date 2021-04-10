package com.hjx.webmaker.modules.base.service;

import java.util.List;

/**
 * 基础服务类提供增删改查
 *
 * @param <T>
 */
public interface IBaseService<T> {
    long countByExample(Object example);

    int deleteByExample(Object example);

    int deleteByPrimaryKey(Object id);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExample(Object example);

//    List<T> selectByExample2(Object example);

    T selectByPrimaryKey(Object id);

    int updateByExampleSelective(T record, Object example);

    int updateByExample(T record, Object example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    String buildKey(String key);
}
