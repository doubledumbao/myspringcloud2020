package com.example.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
public class PaymentConsulController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/consul/msg")
    public String getZooMsg(){
        return "payment consul server.port:"+port +" -- " + UUID.randomUUID().toString();
    }
}
