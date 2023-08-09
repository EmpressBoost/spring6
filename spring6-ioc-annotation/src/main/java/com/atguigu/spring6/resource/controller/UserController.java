package com.atguigu.spring6.resource.controller;

import com.atguigu.spring6.resource.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller("myUserController")
public class UserController {

    //根据名称注入
    /*@Resource(name = "myUserservice")
    private UserService userService;*/

    //根据类型配置
    @Resource
    private UserService userService;

    public void add(){
        System.out.println("UserController....");
        userService.addv();
    }
}
