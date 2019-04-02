package com.ddc.common.demo.persistence.dds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    private final static Logger log = LoggerFactory.getLogger(DynamicRoutingDataSource.class);

    /**
     * 从库切换主库开关
     */
    private final static String S_CG_M = "true";

    private static MasterSlaveSwitchConfig masterSlaveSwitchConfig;

    @Autowired
    public void setMasterSlaveSwitchConfig(MasterSlaveSwitchConfig masterSlaveSwitchConfig){
        this.masterSlaveSwitchConfig = masterSlaveSwitchConfig;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        if(S_CG_M.equals(masterSlaveSwitchConfig.getSlaveChangeMaster().trim())){
            log.info("Current DataSource is [{}]", DataSourceKey.master);
            return DataSourceKey.master;
        }
        log.info("Current DataSource is [{}]", DynamicDataSourceContextHolder.getDataSourceKey());
        return DynamicDataSourceContextHolder.getDataSourceKey();
    }
}
