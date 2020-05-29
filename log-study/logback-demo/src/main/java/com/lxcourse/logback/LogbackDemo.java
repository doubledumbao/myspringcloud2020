package com.lxcourse.logback;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackDemo {
    public static final Logger LOGGER = LoggerFactory.getLogger(LogbackDemo.class);

    @Test
    public void testQuick(){
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info");
        LOGGER.debug("debug");
        LOGGER.trace("trace");
    }
}
