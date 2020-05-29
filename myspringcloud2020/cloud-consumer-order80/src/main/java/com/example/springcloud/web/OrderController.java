package com.example.springcloud.web;


import com.example.springcloud.entity.CommonResult;
import com.example.springcloud.entity.Payment;
import com.example.springcloud.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author doubledumbao
 */
@RestController
public class OrderController {
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalancer loadBalancer;


    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/query/{id}")
    public CommonResult query(@PathVariable Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/query/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/queryForEntity/{id}")
    public CommonResult queryForEntity(@PathVariable Long id) {
        ResponseEntity<CommonResult> ent = restTemplate.getForEntity(PAYMENT_URL + "/payment/query/" + id, CommonResult.class);
        if (ent.getStatusCode().is2xxSuccessful()) {
            return ent.getBody();
        } else {
            return new CommonResult(444, "查询失败");
        }
    }

    @GetMapping("/consumer/payment/createForEntity")
    public CommonResult createForEntity(Payment payment) {
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult(444, "创建失败");
        }
    }

    @GetMapping("/consumer/payment/lb")
    public String paymentLb() {

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() == 0) {
            return null;
        }
        ServiceInstance instance = loadBalancer.getInstance(instances);

        URI uri = instance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }
}
