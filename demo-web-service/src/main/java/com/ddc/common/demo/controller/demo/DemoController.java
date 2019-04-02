package com.ddc.common.demo.controller.demo;

import com.ddc.common.demo.biz.basic.manager.CityManager;
import com.ddc.common.demo.domain.basic.CityDO;
import com.ddc.common.demo.service.demo.DemoService;
import com.ddc.common.demo.common.BaseController;
import com.ddc.common.demo.vo.ResultViewObject;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * DEMO
 *
 * @author mumu.li
 * @version 1.0.0
 */
@Controller
@RequestMapping("/demo")
public class DemoController extends BaseController {

    @Autowired
    private DemoService companyService;

    @Autowired
    private CityManager cityManager;

    @RequestMapping("/")
    public String demo() {
        return "demo/demo";
    }


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