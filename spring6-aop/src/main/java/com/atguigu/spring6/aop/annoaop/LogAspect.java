package com.atguigu.spring6.aop.annoaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//切面类
@Aspect //切面类
@Component //ioc容器
public class LogAspect {

    //设置切入点和通知类型
    //通知类型: 前置 返回 异常 后置 环绕
//    @Before()
//    @AfterReturning
//    @AfterThrowing
//    @After()
//    @Around()

    //切入点表达式：execution(访问修饰符 增强方法返回类型 增强方法所在类的全类名 方法名 方法参数)
    //@Before(value = "切入点表达式配置切入点")
    //    @Before(value = "execution(* int com.atguigu.spring6.aop.annoaop.CalculatorImpl.*(..))")
    @Before(value = "execution(public int com.atguigu.spring6.aop.annoaop.CalculatorImpl.*(..))")
    public  void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger-->前置通知，方法名："+methodName+"，参数："+ Arrays.toString(args));
    }

    //类似于try catch finally的finally 无论如何都会执行
    @After(value = "Pointcut()")
    public  void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->后置通知，方法名："+methodName+"，参数：");
    }

    @AfterReturning(value = "execution(* com.atguigu.spring6.aop.annoaop.CalculatorImpl.*(..))",returning = "rel")
    public  void afterReturningMethod(JoinPoint joinPoint,Object rel){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->返回通知，方法名："+methodName+"，返回结果："+ rel);
    }

    //目标方法出现异常，这个通知执行 获取到目标方法的异常信息
    //有异常才会出现此通知，出现异常通知则不会再出现后置返回通知
    @AfterThrowing(value = "execution(* com.atguigu.spring6.aop.annoaop.CalculatorImpl.*(..))",throwing = "ex")
    public  void afterThrowingMethod(JoinPoint joinPoint,Throwable ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->异常通知，方法名："+methodName+"，返回结果："+ ex);
    }

    @Around(value = "execution(* com.atguigu.spring6.aop.annoaop.CalculatorImpl.*(..))")
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

    //重用切入点表达式
    @Pointcut(value = "execution(* com.atguigu.spring6.aop.annoaop.CalculatorImpl.*(..))")
    public void Pointcut(){

    }
}

