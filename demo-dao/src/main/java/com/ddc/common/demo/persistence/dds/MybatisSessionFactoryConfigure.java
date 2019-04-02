package com.ddc.common.demo.persistence.dds;

import com.baomidou.mybatisplus.autoconfigure.SpringBootVFS;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class MybatisSessionFactoryConfigure {

    @Autowired
    private DataSource dynamicDataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory createSqlSessionFactoryBean(MybatisConfig mybatisConfig) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory  = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dynamicDataSource);
        Interceptor[] interceptors = {new DynamicPlugin(), new PageHelper()};
        //拦截器
        sqlSessionFactory.setPlugins(interceptors);
        sqlSessionFactory.setVfs(SpringBootVFS.class);
        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCacheEnabled(false);
        sqlSessionFactory.setConfiguration(configuration);
        return sqlSessionFactory.getObject();
    }

    /*@Bean(value = "sqlSessionTemplate")
    public SqlSessionTemplate createSqlSessionTemplate(SqlSessionFactory sqlSessionFactory, MybatisConfig mybatisConfig) throws Exception {
        ExecutorType executorType = mybatisConfig.getExecutorType();
        if (executorType != null) {
            return new SqlSessionTemplate(sqlSessionFactory, executorType);
        } else {
            return new SqlSessionTemplate(sqlSessionFactory);
        }
    }*/

    @Bean
    public DataSourceTransactionManager createTransactionManager() throws SQLException {
        return new DynamicDataSourceTransactionManager(dynamicDataSource);
    }

    @Bean
    public TransactionTemplate createTransactionTemplate() throws SQLException {
        return new TransactionTemplate(createTransactionManager());
    }
}
