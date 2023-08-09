package com.atguigu.spring6.iocxml.ditest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmp {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("bean-diarray.xml");
//        Emp emp = con.getBean("emp", Emp.class);
//        emp.work();
        ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("bean-dilist.xml");
        Dept dept = con.getBean("dept", Dept.class);
        dept.info();
    }
}
