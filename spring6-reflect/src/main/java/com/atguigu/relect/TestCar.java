package com.atguigu.relect;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestCar {
    //1、获取Class对象多种方式
    @Test
    public void test1() throws Exception {
        Class<Car> clazz1 = Car.class;
        Class<? extends Car> clazz2 = new Car().getClass();
        Class<?> clazz3 = Class.forName("com.atguigu.relect.Car");
//        Car car = (Car) clazz3.getDeclaredConstructor().newInstance();
        Car car = (Car) clazz3.getConstructor().newInstance();
        System.out.println(car);
    }
    //2、获取构造方法
    @Test
    public void test2() throws Exception {
        Class<Car> clazz1 = Car.class;
        //获取所有构造的方法
        //getConstructors()获取所有构造方法public private
        Constructor<?>[] constructors = clazz1.getDeclaredConstructors();
        //getConstructors()获取所有public的构造方法
//        Constructor<?>[] constructors = clazz1.getConstructors();
        for (Constructor<?> c : constructors) {
            System.out.println("方法名称"+c.getName()+"参数个数："+c.getParameterCount());
        }

        //指定有参构造方法创建对象
        //1 public
       /* Constructor<Car> c1 = clazz1.getConstructor(String.class, Integer.class, String.class);
        Car car1 = c1.newInstance("宝马", 10, "黑色");
        System.out.println(car1);*/
        //2 private
        Constructor<Car> c2 = clazz1.getDeclaredConstructor(String.class, Integer.class, String.class);
        c2.setAccessible(true);
        Car car1 = c2.newInstance("问界", 5, "蓝色");
        System.out.println(car1);

    }
    //3、获取属性
    @Test
    public void test3() throws Exception {
        Class<Car> clazz = Car.class;
        Car car = clazz.getDeclaredConstructor().newInstance();
        //获取所有的public属性
//        Field[] fields = clazz.getFields();
        //获取所有的属性（包含私有属性)
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if(field.getName().equals("name")){
                //设置允许访问
                field.setAccessible(true);
                field.set(car,"五菱宏光");
            }
            System.out.println(field.getName());
            System.out.println(car);
        }

    }
    //4、获取方法
    @Test
    public void test4() throws Exception {
        Car car = new Car("奔驰", 10, "黑色");
        Class clazz = car.getClass();
        //public方法
        Method[] methods = clazz.getMethods();
        for (Method m1 : methods) {
//            System.out.println(m1.getName());
            //执行方法 tostring
            if(m1.getName().equals("toString")){
                String invoke = (String) m1.invoke(car);
                System.out.println("tostring方法执行了："+invoke);
            }
        }
        //private方法
        Method[] methodsAll = clazz.getDeclaredMethods();
        for (Method m1 : methodsAll) {
//            System.out.println(m1.getName());
            //执行方法 run
            if(m1.getName().equals("run")){
                m1.setAccessible(true);
                m1.invoke(car);
            }
        }
    }


}


