package com.ddc.common.demo.api.basic.basicservice;

import com.ddc.common.api.BaseResponseEntity;
import com.ddc.common.demo.api.basic.basicservice.queryByEntity.resp.QueryByEntityResp;
import com.ddc.common.demo.api.basic.basicservice.queryCityByProvinceId.resp.CityEntity;
import com.ddc.common.demo.api.basic.basicservice.queryByEntity.request.QueryByEntityRequest;

import java.util.List;

public interface BasicService {
    /**
     * 根据省查出所有的市
     *
     * @param provinceId
     * @return
     */
    public BaseResponseEntity<CityEntity> queryCityByProvinceId(Long provinceId);

    /**
     * 按实体查询
     * @param queryByEntityRequest
     * @return
     */
    public BaseResponseEntity<List<QueryByEntityResp>> queryByEntity(QueryByEntityRequest queryByEntityRequest);

}
