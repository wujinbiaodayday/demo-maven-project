package com.ddc.common.demo.persistence.common;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;


public abstract class BaseDao<T> implements IDao<T> {

    public abstract BaseMapper<T> getMapper();


    @Override
    public Integer insert(T entity) {
        return getMapper().insert(entity);
    }

    @Override
    public Integer deleteById(Serializable id) {
        return getMapper().deleteById(id);
    }

    @Override
    public Integer deleteByMap(Map<String, Object> columnMap) {
        return getMapper().deleteByMap(columnMap);
    }

    @Override
    public Integer delete(Wrapper<T> queryWrapper) {
        return getMapper().delete(queryWrapper);
    }

    @Override
    public Integer deleteBatchIds(Collection<? extends Serializable> idList) {
        return getMapper().deleteBatchIds(idList);
    }

    @Override
    public Integer updateById(T entity) {
        return getMapper().updateById(entity);
    }

    @Override
    public Integer update(T entity, Wrapper<T> updateWrapper) {
        return getMapper().update(entity, updateWrapper);
    }

    @Override
    public T selectById(Serializable id) {
        return getMapper().selectById(id);
    }

    @Override
    public List<T> selectBatchIds(Collection<? extends Serializable> idList) {
        return getMapper().selectBatchIds(idList);
    }

    @Override
    public List<T> selectByMap(Map<String, Object> columnMap) {
        return getMapper().selectByMap(columnMap);
    }

    @Override
    public T selectOne(Wrapper<T> queryWrapper) {
        return getMapper().selectOne(queryWrapper);
    }

    @Override
    public Integer selectCount(Wrapper<T> queryWrapper) {
        return getMapper().selectCount(queryWrapper);
    }

    @Override
    public List<T> selectList(Wrapper<T> queryWrapper) {
        return getMapper().selectList(queryWrapper);
    }

    @Override
    public List<Map<String, Object>> selectMaps(Wrapper<T> queryWrapper) {
        return getMapper().selectMaps(queryWrapper);
    }

    @Override
    public List<Object> selectObjs(Wrapper<T> queryWrapper) {
        return getMapper().selectObjs(queryWrapper);
    }

    @Override
    public IPage<T> selectPage(IPage<T> page, Wrapper<T> queryWrapper) {
        return getMapper().selectPage(page, queryWrapper);
    }

    @Override
    public IPage<Map<String, Object>> selectMapsPage(IPage<T> page, Wrapper<T> queryWrapper) {
        return getMapper().selectMapsPage(page, queryWrapper);
    }
}