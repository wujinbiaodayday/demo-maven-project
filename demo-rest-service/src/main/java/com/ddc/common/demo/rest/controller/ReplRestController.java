package com.ddc.common.demo.rest.controller;

import com.ddc.common.demo.biz.basic.manager.CityManager;
import com.ddc.common.demo.domain.basic.CityDO;
import com.ddc.common.demo.rest.bean.RestResult;
import com.ddc.common.demo.rest.service.ReplRestService;
import com.ddc.common.demo.rest.vo.ReplHeaderVo;
import com.ddc.common.demo.rest.vo.ResultViewObject;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/demo")
public class ReplRestController {
    Logger logger = LoggerFactory.getLogger(ReplRestController.class);

    @Autowired
    ReplRestService replRestService;

    @Autowired
    private CityManager cityManager;

    @ApiOperation(value = "demo", notes = "根据id获取数据")
    @RequestMapping(value = "city/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResultViewObject<CityDO> queryCityById(@ApiParam(required = true, name = "id", value = "补货单id") @PathVariable(value = "id") Long id) {
        ResultViewObject<CityDO> result = new ResultViewObject<>();
        CityDO cityDO = cityManager.selectById(1L);
        result.setCode(0);
        result.setResult(cityDO);
        return result;
    }
}
