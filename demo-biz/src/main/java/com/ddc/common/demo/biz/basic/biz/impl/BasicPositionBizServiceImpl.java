package com.ddc.common.demo.biz.basic.biz.impl;

import com.ddc.common.demo.api.basic.basicservice.queryCityByProvinceId.resp.CityEntity;
import com.ddc.common.demo.biz.basic.biz.BasicPositionBizService;
import com.ddc.common.demo.biz.basic.manager.CityManager;
import com.ddc.common.demo.domain.basic.CityDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("basicPositionBizService")
public class BasicPositionBizServiceImpl implements BasicPositionBizService {

    @Resource
    private CityManager cityManager;

    @Override
    public CityEntity queryById(Long id) {
        CityDO cityDO = cityManager.selectById(id);
        CityEntity cityEntity = new CityEntity();
        BeanUtils.copyProperties(cityDO, cityEntity);
        return cityEntity;
    }
}