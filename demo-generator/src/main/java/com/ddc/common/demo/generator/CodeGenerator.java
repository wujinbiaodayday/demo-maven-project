package com.ddc.common.demo.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CodeGenerator {

    public static final String path = System.getProperty("user.dir");
    public static final ResourceBundle resourceBundle = ResourceBundle.getBundle("mybatis-plus");
    public static final String JDBC_URI = resourceBundle.getString("jdbc.uri") ;
    public static final String JDBC_USERNAME = resourceBundle.getString("jdbc.username") ;
    public static final String JDBC_PASSWORD = resourceBundle.getString("jdbc.password") ;
    public static final String JDBC_DRIVENAME = resourceBundle.getString("jdbc.drivename") ;
    public static final String OUT_JAVA_DIR = resourceBundle.getString("out.java.dir") ;
    public static final String OUT_MAPPER_DIR = resourceBundle.getString("out.mapper.dir") ;
    public static final String PARENT_PACKAGE = resourceBundle.getString("out.parent.package") ;

    public static void main(String[] args) {

        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();

        // 全局配置
        autoGenerator.setGlobalConfig(
                new GlobalConfig()
                        .setOpen(false)
                        .setOutputDir(OUT_JAVA_DIR) //输出目录
                        .setFileOverride(false)// 是否覆盖文件
                        .setActiveRecord(true)// 开启 activeRecord 模式
                        .setEnableCache(false)// XML 二级缓存
                        .setBaseResultMap(true)// XML ResultMap
                        .setBaseColumnList(true)// XML columList
                        .setAuthor("DDC")
                        .setMapperName("%sMapper")
                        .setXmlName("%sMapper")
                        .setServiceName("%sService")
                        .setServiceImplName("%sServiceImpl")
                        .setControllerName("%sController")
        );

        // 数据源配置
        autoGenerator.setDataSource(
                new DataSourceConfig()
                        .setDbType(DbType.MYSQL)
                        .setDriverName(JDBC_DRIVENAME)
                        .setUsername(JDBC_USERNAME)
                        .setPassword(JDBC_PASSWORD)
                        .setUrl(JDBC_URI)
                        .setTypeConvert(new MySqlTypeConvert() {
                            @Override
                            public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                                if ( fieldType.toLowerCase().contains( "TINYINT" ) ) { return DbColumnType.INTEGER; }
                                if ( fieldType.toLowerCase().contains( "DATETIME" ) ) { return DbColumnType.TIMESTAMP; }
                                if ( fieldType.toLowerCase().contains( "BIGINT" ) ) { return DbColumnType.LONG; }
                                return (DbColumnType) super.processTypeConvert(globalConfig, fieldType);
                            }
                        })
        );

        // 包配置
        autoGenerator.setPackageInfo(
                new PackageConfig().setParent(PARENT_PACKAGE)
        );

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return OUT_MAPPER_DIR + "/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });

        // 自定义配置
        autoGenerator.setCfg(new InjectionConfig() {
            @Override
            public void initMap() {}
        }.setFileOutConfigList(focList));

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        autoGenerator.setTemplate(templateConfig);

        // 策略配置
        autoGenerator.setStrategy(
                new StrategyConfig()
                        .setSuperEntityColumns("id")
                        .setSuperEntityClass("com.baomidou.ant.common.BaseEntity")
                        .setSuperControllerClass("com.baomidou.ant.common.BaseController")
                        .setNaming(NamingStrategy.underline_to_camel)
                        .setColumnNaming(NamingStrategy.underline_to_camel)
                        .setEntityLombokModel(true)
                        .setRestControllerStyle(true)
                        .setControllerMappingHyphenStyle(true)
        );
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        autoGenerator.execute();
    }

}
