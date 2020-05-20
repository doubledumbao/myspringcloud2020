package com.dumbao.fun;

import java.util.function.Predicate;

/**
 * Predicate:断定型接口看，有一个输入参数，返回值只能是布尔值！
 */
public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<String> predicate = new Predicate<String>() {
            //判断字符串是否为空
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };
        System.out.println(predicate.test("hello"));

        System.out.println("----------------");

        Predicate<String> myPredicate = (str)->{
            return str.isEmpty();
        };
        System.out.println(predicate.test("hello"));
    }
}
