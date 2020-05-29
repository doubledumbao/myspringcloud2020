package com.example.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Component
@Slf4j
public class MyLb implements LoadBalancer{

    private final AtomicInteger currentCount = new AtomicInteger(0);
    @Override
    public ServiceInstance getInstance(List<ServiceInstance> instances) {

        int next = getAndIncrement();
        log.info("MyLb index:{}",next);
        int index = next % instances.size();
        return instances.get(index);
    }

    private int getAndIncrement() {
        int cur ;
        int next;
        do{
            cur = currentCount.get();
            next = cur == Integer.MAX_VALUE ? 0 : cur + 1;
            log.info("cur:{},next:{}",cur,next);

        }while(!currentCount.compareAndSet(cur,next));
        log.info("第{}次访问",next);
        return  next;
    }
}
