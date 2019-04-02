package com.ddc.common.demo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.concurrent.CountDownLatch;

@EnableTransactionManagement//开启事务
@SpringBootApplication(scanBasePackages = "com.ddc.common.demo")
@ImportResource({"classpath:spring/dubbo-provider.xml", "classpath:mq.xml"})
@MapperScan("com.ddc.common.demo.persistence.*.mapper")
@EnableApolloConfig
public class DemoDubboServiceApplication implements CommandLineRunner, DisposableBean {

    private final Logger log = LoggerFactory.getLogger(DemoDubboServiceApplication.class);

    private final static CountDownLatch latch = new CountDownLatch(1);
    private static ConfigurableApplicationContext context;

    public static void main(String[] args) throws InterruptedException {
        context = SpringApplication.run(DemoDubboServiceApplication.class, args);
        latch.await();
    }

    @Override
    public void destroy() throws Exception {
        latch.countDown();
        context.close();
        log.info("服务提供者关闭------>>服务关闭");
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("服务提供者启动完毕------>>启动完毕");
    }
}
