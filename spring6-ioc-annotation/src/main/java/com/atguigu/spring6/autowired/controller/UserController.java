package com.atguigu.spring6.autowired.controller;

import com.atguigu.spring6.autowired.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    //1.属性注入
    @Autowired
    private UserService userService;

    //2.set方法注入
/*    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }*/

    //3.构造方法注入
/*    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }*/
    //4.形参注入
/*    private UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }*/
    //5.只有一个有参数构造，无注解
/*
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserController() {
    }
*/


    public void add(){
        System.out.println("UserController....");
        userService.addv();
    }
}
