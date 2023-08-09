package com.atguigu.spring6.aop.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {
    //目标对象
    private Object target;
    public ProxyFactory(Object target){
        this.target=target;
    }
    //返回代理对象
    public Object getProxy(){
   /*     *//**
         * ClassLoader loader, 加载动态生成代理类的类加载器
         * Class<?>[] interfaces,目标对象实现的所有接口的clss类型的数组
         * InvocationHandler h 设置代理对象实现目标对象的过程
         *//*
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler invocationHandler=new InvocationHandler(){

            *//**
             * 代理对象
             * @param proxy 调用该方法的代理实例
             * 需要重写目标对象的方法
             * @param method 与在代理实例上调用的接口方法对应的 Method 实例。 Method 对象的声明类将是声明该方法的接口，它可能是代理类通过其继承该方法的代理接口的超接口。
             * method里面的参数
             * @param args 包含在代理实例的方法调用中传递的参数值的对象数组，或者 null 如果接口方法不带参数。原始类型的参数包装在适当的原始包装类的实例中，例如 java.lang.Integer 或 java.lang.Boolean 。
             * @return
             * @throws Throwable
             *//*
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("[动态代理][日志] "+method.getName()+"，参数："+ Arrays.toString(args));
                Object result = method.invoke(target, args);
                System.out.println("[动态代理][日志] "+method.getName()+"，结果："+ result);
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);*/

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("[动态代理][日志] "+method.getName()+"，参数："+ Arrays.toString(args));
                Object result = method.invoke(target, args);
                System.out.println("[动态代理][日志] "+method.getName()+"，结果："+ result);
                return result;
            }
        });
    }
}
