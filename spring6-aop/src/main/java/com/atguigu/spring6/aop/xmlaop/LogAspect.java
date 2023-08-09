package com.atguigu.spring6.aop.xmlaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//切面类
@Component //ioc容器
public class LogAspect {


    public  void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger-->前置通知，方法名："+methodName+"，参数："+ Arrays.toString(args));
    }

    //类似于try catch finally的finally 无论如何都会执行
    public  void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->后置通知，方法名："+methodName+"，参数：");
    }

    public  void afterReturningMethod(JoinPoint joinPoint,Object rel){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->返回通知，方法名："+methodName+"，返回结果："+ rel);
    }

    //目标方法出现异常，这个通知执行 获取到目标方法的异常信息
    //有异常才会出现此通知，出现异常通知则不会再出现后置返回通知
    public  void afterThrowingMethod(JoinPoint joinPoint,Throwable ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->异常通知，方法名："+methodName+"，返回结果："+ ex);
    }

    public  Object aroundMethod(ProceedingJoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String argString = Arrays.toString(args);
        System.out.println("Logger-->环绕通知，方法名："+methodName+"，返回结果："+ argString);
        Object result=null;
        try {
            System.out.println("环绕通知==目标方法之前执行");
            //调用目标方法
            result = joinPoint.proceed();
            System.out.println("环绕通知==目标方法返回值之后");

        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("环绕通知==目标方法出现异常");
        }finally {
            System.out.println("环绕通知==目标方法执行完毕执行");
        }
        return result;
    }

}

