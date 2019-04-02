package com.ddc.common.demo.biz.basic.biz;

import com.ddc.common.demo.api.basic.basicservice.queryCityByProvinceId.resp.CityEntity;

public interface BasicPositionBizService {

    /**
     * 根据Id查询city
     *
     * @param id
     * @return
     */
    public CityEntity queryById(Long id);
}