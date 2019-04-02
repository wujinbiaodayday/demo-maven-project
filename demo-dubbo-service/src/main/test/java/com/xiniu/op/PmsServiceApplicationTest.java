package com.xiniu.op;

import com.ddc.scm.demo.DemoDubboServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoDubboServiceApplication.class)
public class PmsServiceApplicationTest {

    private static final Logger logger = LoggerFactory.getLogger(PmsServiceApplicationTest.class);


    @Test
    public void testConfig() {
        logger.info("ttttt");

    }
}