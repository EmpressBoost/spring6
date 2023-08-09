package com.atguigu.spring6.aop.example;

public class TestCal {
    public static void main(String[] args) {
        //静态
/*
        CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
        proxy.add(1,2);
*/

        //创建代理对象(动态）
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
//        proxy.add(1,2);
        proxy.mul(2,3);
    }
}
