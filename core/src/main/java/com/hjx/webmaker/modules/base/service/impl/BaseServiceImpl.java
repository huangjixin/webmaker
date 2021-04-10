package com.hjx.webmaker.modules.base.service.impl;

import com.hjx.webmaker.modules.base.mapper.BaseMapper;
import com.hjx.webmaker.modules.base.service.IBaseService;
import org.slf4j.Logger;

import java.util.List;

public abstract class BaseServiceImpl<T> implements IBaseService<T> {
    // 注入mybaties基础接口层,由子类提供
    protected abstract BaseMapper getBaseMapper();

    // 由子类提供基础消息。
    protected abstract String getBaseMessage();

    // 由子类提供基础消息。
    protected abstract String getKeyPre();

    // 消息日志打印输出，由子类提供真正的日志实现。
    protected abstract Logger getLogger();

    @Override
    public long countByExample(Object example) {
        long result = getBaseMapper().countByExample(example);
        return result;
    }

    @Override
    public int deleteByExample(Object example) {
        int result = getBaseMapper().deleteByExample(example);
        return result;
    }

    @Override
    public int deleteByPrimaryKey(Object id) {
        int result = getBaseMapper().deleteByPrimaryKey(id);
        return result;
    }

    @Override
    public int insert(Object record) {
        int result = getBaseMapper().insert(record);
        return result;
    }

    @Override
    public int insertSelective(Object record) {
        int result = getBaseMapper().insertSelective(record);
        return result;
    }

    @Override
    public List<T> selectByExample(Object example) {
        List<T> list = getBaseMapper().selectByExample(example);
        return list;
    }

//    @Override
//    public List<T> selectByExample2(Object example) {
//        List<T>list =  getBaseMapper().selectByExample2(example);
//        return list;
//    }

    @Override
    public T selectByPrimaryKey(Object id) {
        T record = (T) getBaseMapper().selectByPrimaryKey(id);
        return record;
    }

    @Override
    public int updateByExampleSelective(Object record, Object example) {
        int result = getBaseMapper().updateByExampleSelective(record, example);
        return result;
    }

    @Override
    public int updateByExample(Object record, Object example) {
        int result = getBaseMapper().updateByExample(record, example);
        return result;
    }

    @Override
    public int updateByPrimaryKeySelective(Object record) {
        int result = getBaseMapper().updateByPrimaryKeySelective(record);
        return result;
    }

    @Override
    public int updateByPrimaryKey(Object record) {
        int result = getBaseMapper().updateByPrimaryKey(record);
        return result;
    }

    @Override
    public String buildKey(String key) {
        return getKeyPre() + key;
    }
}
