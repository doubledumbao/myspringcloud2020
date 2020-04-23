package com.lxcourse.formlogin.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController{

    @GetMapping("/hello")
    public String hello(){
        return "刘雪课堂:www.lxcourse.cn";
    }
}