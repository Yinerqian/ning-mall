package com.atguigu.gulimall.gateway.controller;

import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

//@RefreshScope
@RestController
@RequestMapping("/gateway/user")
public class TestController {

    @PostConstruct
    public void postConstruct() {
        System.out.println("=====================================");
    }

    @Value("${user.name}")
    private String name;

    @Value("${user.age}")
    private Integer age;

    @GetMapping("/getUser")
    public String getUser() {
        return "名字：" + name + "===, 年龄是：" + age;
    }


}
