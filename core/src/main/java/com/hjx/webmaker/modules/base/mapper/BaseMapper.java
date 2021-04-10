package com.hjx.webmaker.modules.base.mapper;

import java.util.List;

//extends Mapper
public interface BaseMapper<T> {
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
}
