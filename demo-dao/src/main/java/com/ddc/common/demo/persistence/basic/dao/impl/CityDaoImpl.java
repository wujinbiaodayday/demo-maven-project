package com.ddc.common.demo.persistence.basic.dao.impl;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ddc.common.demo.domain.basic.CityDO;
import com.ddc.common.demo.persistence.basic.dao.CityDao;
import com.ddc.common.demo.persistence.common.BaseDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("cityDao")
public class CityDaoImpl extends BaseDao<CityDO> implements CityDao<CityDO> {
    @Resource
    private BaseMapper<CityDO> cityMapper;

    @Override
    public BaseMapper<CityDO> getMapper() {
        return cityMapper;
    }
}