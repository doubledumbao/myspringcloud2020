package com.lxcourse.jcl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class JCLDemo {

    @Test
    public void testQuick(){
        Log log = LogFactory.getLog(JCLDemo.class);
        log.info("hello jcl");
    }
}
