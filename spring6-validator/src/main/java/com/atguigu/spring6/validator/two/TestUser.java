package com.atguigu.spring6.validator.two;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUser {

    @Test
    public void testValidationOne(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyValidation1 validation1 = context.getBean(MyValidation1.class);
        User user = new User();
        user.setName("lucy");
        user.setAge(20);
        boolean b = validation1.validatorUserByOne(user);
        System.out.println(b);
    }

    @Test
    public void testValidationTwo(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyValidation2 validation2 = context.getBean(MyValidation2.class);
        User user = new User();
        user.setName("lucy");
        user.setAge(200);
        boolean b = validation2.validatorUserByTwo(user);
        System.out.println(b);
    }
}
