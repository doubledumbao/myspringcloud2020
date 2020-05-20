package com.example.springcloud.web;


import com.example.springcloud.entity.CommonResult;
import com.example.springcloud.entity.Payment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {
    private static  final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/query/{id}")
    public CommonResult query(@PathVariable Long id){
       return restTemplate.getForObject(PAYMENT_URL + "/payment/query/" + id, CommonResult.class);
    }
}
