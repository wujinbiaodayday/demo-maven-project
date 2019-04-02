package com.ddc.common.demo.biz.basic.manager;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ddc.common.demo.domain.basic.CityDO;

public interface CityManager {

    /**
     * 根据Id查询city
     * @param id
     * @return
     */
    public CityDO selectById(Long id);

    public IPage<CityDO> selectByPage();
}