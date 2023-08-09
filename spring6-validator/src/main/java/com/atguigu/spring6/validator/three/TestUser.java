package com.atguigu.spring6.validator.three;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ValidationConfig.class);
        Myservice myservice = context.getBean(Myservice.class);
        User user = new User();
        user.setName("lucy");
        user.setPhone("13577878788");
        user.setMessage("test  a t guigu");
        myservice.testUser(user);
    }
}
