package com.ddc.common.demo.persistence.dds;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 主从切换
 */
@Configuration
public class MasterSlaveSwitchConfig {

    /**
     * 数据源开关 默认不切换
     */
    @Value("${slave.change.master:false}")
    private String slaveChangeMaster;

    public String getSlaveChangeMaster(){
        return slaveChangeMaster;
    }




}
