package com.example.springcloud.service.impl;

import com.example.springcloud.dao.PaymentDao;
import com.example.springcloud.entity.Payment;
import com.example.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;
    @Override
    public Payment selectByPrimaryKey(Long id) {
        return paymentDao.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Payment record) {
        return paymentDao.insert(record);
    }
}
