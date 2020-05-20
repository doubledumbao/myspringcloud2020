package com.example.springcloud.service;

import com.example.springcloud.entity.Payment;
import org.springframework.stereotype.Service;

public interface PaymentService {
    Payment selectByPrimaryKey(Long id);

    int insert(Payment record);
}
