package com.ddc.common.demo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication(scanBasePackages = "com.ddc.common.demo")
@EnableAutoConfiguration
@EnableApolloConfig(value = {"application", "TEST1.redis"})
@EnableScheduling
@ImportResource({"classpath:spring/dubbo.xml", "classpath:spring/job-executor.xml"})
public class PmsJobApplication implements CommandLineRunner, DisposableBean {

    private final Logger log = LoggerFactory.getLogger(PmsJobApplication.class);

    private final static CountDownLatch latch = new CountDownLatch(1);
    private static ConfigurableApplicationContext context;

    public static void main(String[] args) throws InterruptedException {
        context = SpringApplication.run(PmsJobApplication.class, args);
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