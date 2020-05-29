package com.lxcourse.slf4j;

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
        String name = "lxcourse";
        String url = "https://www.lxcourse.cn";
        LOGGER.info("网站:{}，网址:{}",name,url);

        try {
            int a = 10/0;
        } catch (Exception e) {
            LOGGER.error("发生异常{}","hello",e);
        }
    }

}
