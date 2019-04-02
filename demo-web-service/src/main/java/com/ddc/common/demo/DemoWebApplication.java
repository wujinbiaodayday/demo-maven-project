package com.ddc.common.demo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;

@EnableTransactionManagement//开启事务
@SpringBootApplication(scanBasePackages = "com.ddc.common.demo")
@ImportResource(locations = {"classpath:consumer.xml", "classpath*:authority-filter-consumers.xml"})
@ComponentScan(basePackages = {"com.ddc.common.demo"})
//@ComponentScan(basePackages = {"com.ddc.authority"})
@MapperScan("com.ddc.common.demo.persistence.*.mapper")
@EnableApolloConfig
public class DemoWebApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(DemoWebApplication.class, args);
		System.out.println("WebSpringBoot is run");
	}
	
}
