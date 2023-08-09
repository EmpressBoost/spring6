package com.atguigu.spring6;

import com.atguigu.spring6.bean.AnnotationApplicationContext;
import com.atguigu.spring6.bean.ApplicationContext;
import com.atguigu.spring6.service.UserService;

public class TestUser {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationApplicationContext("com.atguigu.spring6");
        UserService userService = (UserService) context.getBean(UserService.class);
        System.out.println(userService);
        userService.add();
    }
}
