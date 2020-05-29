package com.lxcourse.log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.junit.Test;

/**
 * @author doubledumbao
 * 测试log4j
 */
public class Log4jDemo {

    @Test
    public void testQuick() {
        //初始化配置信息，在入门案例中暂不使用配置文件
        BasicConfigurator.configure();
        Logger logger = Logger.getLogger(Log4jDemo.class);

        logger.info("hello log4j");

        //日志级别
        logger.fatal("fatal"); //严重错误，一般会造成系统崩溃并终止运行
        logger.error("error"); // 错误信息，不影响系统运行
        logger.warn("warn"); // 警告信息，可能会发生问题
        logger.info("info"); // 运行信息
        logger.debug("debug"); // 调试信息
        logger.trace("trace"); // 追踪信息，记录程序所有的流程信息
    }

    /**
     * 配置文件log4j.properties
     */
    @Test
    public void testConfigFile() {
        Logger logger = Logger.getLogger(Log4jDemo.class);

        logger.info("hello log4j");

        //日志级别
        logger.fatal("fatal"); //严重错误，一般会造成系统崩溃并终止运行
        logger.error("error"); // 错误信息，不影响系统运行
        logger.warn("warn"); // 警告信息，可能会发生问题
        logger.info("info"); // 运行信息
        logger.debug("debug"); // 调试信息
        logger.trace("trace"); // 追踪信息，记录程序所有的流程信息
    }

    /**
     * 开启log4j内置日志记录
     */
    @Test
    public void testLogLog() {
        //开启log4j内置日志记录
        LogLog.setInternalDebugging(true);
        Logger logger = Logger.getLogger(Log4jDemo.class);

        logger.info("hello log4j");

        //日志级别
        logger.fatal("fatal"); //严重错误，一般会造成系统崩溃并终止运行
        logger.error("error"); // 错误信息，不影响系统运行
        logger.warn("warn"); // 警告信息，可能会发生问题
        logger.info("info"); // 运行信息
        logger.debug("debug"); // 调试信息
        logger.trace("trace"); // 追踪信息，记录程序所有的流程信息
    }

    /**
     * 测试FileAppender
     */
    @Test
    public void testFileAppender() {
        //开启log4j内置日志记录
        LogLog.setInternalDebugging(true);
        Logger logger = Logger.getLogger(Log4jDemo.class);

        logger.info("hello log4j");

        for (int i = 0; i < 1000; i++) {
            //日志级别
            logger.fatal("fatal"); //严重错误，一般会造成系统崩溃并终止运行
            logger.error("error"); // 错误信息，不影响系统运行
            logger.warn("warn"); // 警告信息，可能会发生问题
            logger.info("info"); // 运行信息
            logger.debug("debug"); // 调试信息
            logger.trace("trace"); // 追踪信息，记录程序所有的流程信息
        }
    }

    /**
     * 测试自定义日志
     */
    @Test
    public void testSelfLogger() {
        //开启log4j内置日志记录
        LogLog.setInternalDebugging(true);
        Logger logger = Logger.getLogger(Log4jDemo.class);

        logger.info("hello log4j");

        //日志级别
        logger.fatal("fatal"); //严重错误，一般会造成系统崩溃并终止运行
        logger.error("error"); // 错误信息，不影响系统运行
        logger.warn("warn"); // 警告信息，可能会发生问题
        logger.info("info"); // 运行信息
        logger.debug("debug"); // 调试信息
        logger.trace("trace"); // 追踪信息，记录程序所有的流程信息

        Logger logger1 = Logger.getLogger(Logger.class);
        //日志级别
        logger1.fatal("fatal logger1"); //严重错误，一般会造成系统崩溃并终止运行
        logger1.error("error logger1"); // 错误信息，不影响系统运行
        logger1.warn("warn logger1"); // 警告信息，可能会发生问题
        logger1.info("info logger1"); // 运行信息
        logger1.debug("debug logger1"); // 调试信息
        logger1.trace("trace logger1"); // 追踪信息，记录程序所有的流程信息
    }
}
