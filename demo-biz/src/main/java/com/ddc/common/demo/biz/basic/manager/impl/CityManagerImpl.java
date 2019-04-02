package com.ddc.common.demo.biz.basic.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ddc.common.demo.biz.basic.manager.CityManager;
import com.ddc.common.demo.domain.basic.CityDO;
import com.ddc.common.demo.persistence.basic.dao.CityDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("cityManager")
public class CityManagerImpl implements CityManager {

    @Resource
    private CityDao<CityDO> cityDao;

    @Override
    public CityDO selectById(Long id) {
        return cityDao.selectById(id);
    }

    @Override
    public IPage<CityDO> selectByPage() {
        QueryWrapper<CityDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", 1);

        IPage<CityDO> page = new Page<>(1, 2);

        return cityDao.selectPage(page, queryWrapper);
    }
}