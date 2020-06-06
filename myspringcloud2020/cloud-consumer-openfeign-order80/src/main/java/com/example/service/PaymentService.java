package com.example.service;

import com.example.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
// value的值为注册中心中服务提供者的实例名称
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentService {

    @GetMapping("/payment/query/{id}")
    public CommonResult query(@PathVariable(value = "id") Long id);

    @GetMapping("/payment/timeout")
    public String paymentTimeout();

}
