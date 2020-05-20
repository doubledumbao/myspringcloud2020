package com.example.springcloud.controller;

import com.example.springcloud.entity.CommonResult;
import com.example.springcloud.entity.Payment;
import com.example.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/query/{id}")
    public CommonResult query(@PathVariable(value = "id") Long id){
        Payment payment = paymentService.selectByPrimaryKey(id);
        if(payment!=null){
            return new CommonResult(200,"success",payment);
        }else{
            return new CommonResult(400,"未查询到数据");
        }
    }
    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int rows = paymentService.insert(payment);
        if(rows>0){
            return new CommonResult(200,"创建成功");
        }else {
            return new CommonResult(400,"创建失败");
        }

    }

}
