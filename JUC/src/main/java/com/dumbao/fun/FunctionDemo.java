package com.dumbao.fun;

import java.util.function.Function;

public class FunctionDemo {
    /**
     * 函数式编程
     * @param args
     */
    public static void main(String[] args) {
        Function<String,String> fun = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s;
            }
        };
        System.out.println(fun.apply("hello world!"));

        System.out.println("-----------------");

        Function<String,String> myFun = (str)->{
            return str;
        };
        System.out.println(myFun.apply("hello java!"));
    }
}
