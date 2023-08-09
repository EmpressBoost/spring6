package com.atguigu.spring6.iocxml.di;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBook {

    @Test
    public void testSetter(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
//        Book book = context.getBean("bookCon", Book.class);
//        System.out.println(book);
    }
}
