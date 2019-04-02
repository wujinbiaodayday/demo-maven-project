package com.ddc.common.demo.persistence.dds;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据源
 */
@Configuration
public class DataSourceConfigurer {

    @Bean("master")
    @ConfigurationProperties(prefix = "spring.datasource.druid.write")
    public javax.sql.DataSource master(){
        javax.sql.DataSource dataSource =  DruidDataSourceBuilder.create().build();
        return dataSource;
    }

    @Bean("slave")
    @ConfigurationProperties(prefix = "spring.datasource.druid.read")
    public javax.sql.DataSource slave(){
        return DruidDataSourceBuilder.create().build();
    }


    /**
     * Dynamic data source.
     *
     * @return the data source
     */
    @Bean("dynamicDataSource")
    public javax.sql.DataSource dynamicDataSource(@Qualifier("master") javax.sql.DataSource master,@Qualifier("slave") javax.sql.DataSource slave) {

        Map<Object, Object> dataSourceMap = new HashMap<>(2);
        dataSourceMap.put(DataSourceKey.master.name(), master);
        dataSourceMap.put(DataSourceKey.slave.name(), slave);
        DynamicRoutingDataSource dynamicRoutingDataSource = new DynamicRoutingDataSource();
        // 将 master 数据源作为默认指定的数据源
        dynamicRoutingDataSource.setDefaultTargetDataSource(master);
        // 将 master 和 slave 数据源作为指定的数据源
        dynamicRoutingDataSource.setTargetDataSources(dataSourceMap);

        // 将数据源的 key 放到数据源上下文的 key 集合中，用于切换时判断数据源是否有效
        DynamicDataSourceContextHolder.dataSourceKeys.addAll(dataSourceMap.keySet());

        // 将 Slave 数据源的 key 放在集合中，用于轮循
        //DynamicDataSourceContextHolder.slaveDataSourceKeys.addAll(dataSourceMap.keySet());
        //DynamicDataSourceContextHolder.slaveDataSourceKeys.remove(DataSourceKey.master.name());
        return dynamicRoutingDataSource;
    }
}
