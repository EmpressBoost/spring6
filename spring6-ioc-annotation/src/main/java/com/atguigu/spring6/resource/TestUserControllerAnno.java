package com.atguigu.spring6.resource;

import com.atguigu.spring6.config.Spring6Config;
import com.atguigu.spring6.resource.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUserControllerAnno {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Spring6Config.class);
        UserController userController = context.getBean(UserController.class);
        userController.add();
    }
}
