package com.atguigu.spring6.iocxml.scop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrder {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-scope.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println(orders);
        Orders orders1 = context.getBean("orders", Orders.class);
        System.out.println(orders1);
    }
}
