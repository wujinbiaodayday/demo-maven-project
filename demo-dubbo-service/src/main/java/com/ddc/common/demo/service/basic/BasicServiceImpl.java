package com.ddc.common.demo.service.basic;

import com.ddc.common.api.BaseResponseEntity;
import com.ddc.common.demo.api.basic.basicservice.BasicService;
import com.ddc.common.demo.api.basic.basicservice.queryByEntity.request.QueryByEntityRequest;
import com.ddc.common.demo.api.basic.basicservice.queryByEntity.resp.QueryByEntityResp;
import com.ddc.common.demo.api.basic.basicservice.queryCityByProvinceId.resp.CityEntity;
import com.ddc.common.demo.biz.basic.biz.BasicPositionBizService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("basicService")
public class BasicServiceImpl implements BasicService {

    @Resource
    private BasicPositionBizService basicPositionBizService;

    @Override
    public BaseResponseEntity<CityEntity> queryCityByProvinceId(Long provinceId) {
        CityEntity resp = basicPositionBizService.queryById(provinceId);
        return BaseResponseEntity.success(resp);
    }

    @Override
    public BaseResponseEntity<List<QueryByEntityResp>> queryByEntity(QueryByEntityRequest queryByEntityRequest) {
        return null;
    }
}
