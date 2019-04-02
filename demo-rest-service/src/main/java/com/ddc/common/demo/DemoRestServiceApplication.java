package com.ddc.common.demo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;

@EnableTransactionManagement//开启事务
@SpringBootApplication(scanBasePackages = "com.ddc.common.demo")
@ImportResource(locations = {"classpath:consumer.xml"})
@ComponentScan(basePackages = {"com.ddc.common.demo"})
@MapperScan("com.ddc.common.demo.persistence.*.mapper")
@EnableApolloConfig
//@EnableSwagger2  //开启swagger
public class DemoRestServiceApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(DemoRestServiceApplication.class, args);
        System.out.println("RestSpringBoot is run");
    }
}
