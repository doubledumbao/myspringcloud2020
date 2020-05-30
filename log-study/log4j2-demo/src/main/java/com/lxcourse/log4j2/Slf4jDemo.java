package com.lxcourse.log4j2;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author doubledumbao
 * Slf4j快速入门
 */
public class Slf4jDemo {

    public static final Logger LOGGER = LoggerFactory.getLogger(Slf4jDemo.class);

    @Test
    public  void testQuick(){
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info");
        LOGGER.debug("debug");
        LOGGER.trace("trace");
    }

}
