package com.example.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/zoo/msg")
    public String getZooMsg(){
        return "payment zookeeper server.port"+port +" -- " +UUID.randomUUID().toString();
    }
}
