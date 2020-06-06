package com.example.controller;

import com.example.service.PaymentService;
import com.example.springcloud.entity.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author doubledumbao
 */
@RestController
public class OrderController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/query/{id}")
    public CommonResult query(@PathVariable Long id) {
        return paymentService.query(id);
    }

    @GetMapping("/consumer/payment/timeout")
    public String paymentTimeout(){
        return paymentService.paymentTimeout();
    }
}
