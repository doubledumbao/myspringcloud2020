package com.example.springbootdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        //System.out.println(Objects.hash("abc"));
        int i = 3;
        System.out.println(~i);
    }

    private static void method2() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        list.add("d");
        list.add("e");
        list.add("f");
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        System.out.println(list);
        //list.remove(2);
        list.retainAll(list1);
        System.out.println(list);
    }

    private static void method1() {
        int a = 16;
        System.out.println(a>>3);
    }
}
