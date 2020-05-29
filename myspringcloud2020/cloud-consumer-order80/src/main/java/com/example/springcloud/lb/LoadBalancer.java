package com.example.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 手写负载均衡器
 */
public interface LoadBalancer {

    public ServiceInstance getInstance(List<ServiceInstance> instances);
}
