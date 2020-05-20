package com.dumbao.fun;

import java.util.UUID;
import java.util.function.Supplier;

/**
 * g供给型接口：无输入参数，有返回值
 */
public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return UUID.randomUUID().toString().replace("-","");
            }
        };
        System.out.println(supplier.get());
        System.out.println("------------------");

        Supplier<String> supplier1 = () ->{
            return UUID.randomUUID().toString().replace("-","");
        };
        System.out.println(supplier1.get());
    }
}
