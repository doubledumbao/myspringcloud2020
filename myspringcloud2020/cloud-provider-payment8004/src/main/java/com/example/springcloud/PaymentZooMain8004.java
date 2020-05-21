package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentZooMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentZooMain8004.class,args);
    }
}
