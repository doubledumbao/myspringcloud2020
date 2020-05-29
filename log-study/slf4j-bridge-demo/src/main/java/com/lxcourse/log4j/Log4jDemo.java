package com.lxcourse.log4j;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author doubledumbao
 */
public class Log4jDemo {

    public static Logger LOGGER = Logger.getLogger(Log4jDemo.class);

    @Test
    public void testQuick(){
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info");
        LOGGER.debug("debug");
        LOGGER.trace("trace");
    }
}
