package com.example;

import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


public class SnakeYamlTest {

    @Test
    public void test1() {
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(
                    new File("/Users/doubledumbao/git/yaml-demo/snakeyml-demo/src/test/resources/demo1.yml")));
            Yaml yaml = new Yaml();
            Map load = yaml.load(bis);
            System.out.println(load);
            System.out.println(load.get("Mark McGwire"));
            Map map = (Map) load.get("Mark McGwire");
            System.out.println(map.get("hr"));
            ArrayList users = (ArrayList) load.get("users");
            System.out.println(users);
            LinkedHashMap user1 = (LinkedHashMap) users.get(0);
            System.out.println("name:" + user1.get("name"));
            System.out.println("age:" + user1.get("age"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
