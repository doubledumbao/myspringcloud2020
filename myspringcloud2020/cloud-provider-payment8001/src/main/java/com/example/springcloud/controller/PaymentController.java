package com.example.springcloud.controller;

import com.example.springcloud.entity.CommonResult;
import com.example.springcloud.entity.Payment;
import com.example.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.ObjectInputStream;
import java.util.List;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/query/{id}")
    public CommonResult query(@PathVariable(value = "id") Long id){
        Payment payment = paymentService.selectByPrimaryKey(id);
        if(payment!=null){
            return new CommonResult(200,"success port:"+port,payment);
        }else{
            return new CommonResult(400,"未查询到数据");
        }
    }
    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int rows = paymentService.insert(payment);
        if(rows>0){
            return new CommonResult(200,"创建成功 port:"+port);
        }else {
            return new CommonResult(400,"创建失败");
        }

    }

    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element: services) {
            log.info("element:{}",element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance:instances){
            log.info("{} --  {} --  {} --  {} -- {}",instance.getInstanceId(),instance.getHost(),instance.getPort(),instance.getUri(),instance.getServiceId());
        }

        return instances;
    }

}
