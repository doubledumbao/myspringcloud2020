package com.lxcourse.springbootlog;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootLogApplicationTests {

    public static final Logger LOGGER = LoggerFactory.getLogger(SpringbootLogApplication.class);

    @Test
    public void testQuick(){
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info");
        LOGGER.debug("debug");
        LOGGER.trace("trace");

        org.apache.logging.log4j.Logger logger = LogManager.getLogger(SpringbootLogApplication.class);
        logger.info("log4j2 log");
    }

}
