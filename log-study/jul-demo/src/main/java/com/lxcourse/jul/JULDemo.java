package com.lxcourse.jul;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.*;

/**
 * @author doubledumbao
 */
public class JULDemo {


    @Test
    public void testQuick() {
        //获取日志记录器对象
        Logger logger = Logger.getLogger("com.lxcourse.jul.JULDemo");
        //日志记录输出
        logger.info("hello jul");
        //通用方法进行日志记录
        logger.log(Level.INFO, "hello world");
        //占位符方式输出变量值
        logger.log(Level.INFO, "用户信息：姓名：{0}，年龄：{1}", new Object[]{"zhangsan", 23});

    }

    /**
     * 测试日志级别
     */
    @Test
    public void testLevel(){
        //获取日志记录器对象
        Logger logger = Logger.getLogger("com.lxcourse.jul.JULDemo");
        //日志级别
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    /**
     * 自定义日志级别
     */
    @Test
    public void testLogConfig() throws IOException {
        //获取日志记录器对象
        Logger logger = Logger.getLogger("com.lxcourse.jul.JULDemo");
        //关闭默认日志级别
        logger.setUseParentHandlers(false);
        //输出到控制台
        ConsoleHandler consoleHandler = new ConsoleHandler();
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        consoleHandler.setFormatter(simpleFormatter);
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);
        //输出到文件
        FileHandler fileHandler = new FileHandler("/Users/doubledumbao/logs/jul.log");
        fileHandler.setFormatter(simpleFormatter);
        logger.addHandler(fileHandler);
        //日志级别
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    /**
     * 日志对象父子关系
     */
    @Test
    public void testLogParent(){
        //子
        Logger logger1 = Logger.getLogger("com.lxcourse");
        //父
        Logger logger2 = Logger.getLogger("com");

        System.out.println(logger1.getParent() == logger2);
        //所有日志记录器的顶级父元素java.util.logging.LogManager$RootLogger ，name ""
        System.out.println("logger2 parent:"+logger2.getParent()+",name:"+logger2.getParent().getName());
        //关闭默认配置
        logger2.setUseParentHandlers(false);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        consoleHandler.setFormatter(simpleFormatter);
        logger2.addHandler(consoleHandler);
        logger2.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);
        //日志级别
        logger1.severe("severe");
        logger1.warning("warning");
        logger1.info("info");
        logger1.config("config");
        logger1.fine("fine");
        logger1.finer("finer");
        logger1.finest("finest");

    }

    @Test
    public void print(){
        //String fname = System.getProperty("java.util.logging.config.file");
        String fname = System.getProperty("java.home");
        System.out.println(fname);
    }

    /**
     * 配置文件
     * @throws IOException
     */
    @Test
    public void testConfigFile() throws IOException {
        InputStream inputStream = JULDemo.class.getClassLoader().getResourceAsStream("logging.properties");
        Logger logger = Logger.getLogger("com.lxcourse.jul.JULDemo");
        LogManager manager = LogManager.getLogManager();
        manager.readConfiguration(inputStream);
        //日志级别
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");

        Logger logger2 = Logger.getLogger("com.lxcourse");

        logger2.severe("severe test");
        logger2.warning("warning test");
        logger2.info("info test");
        logger2.config("config test");
        logger2.fine("fine test");
        logger2.finer("finer test");
        logger2.finest("finest test");
    }
}
