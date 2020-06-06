package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//开启feignclient
@EnableFeignClients
public class OpenFeignOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignOrderMain80.class,args);
    }
}
