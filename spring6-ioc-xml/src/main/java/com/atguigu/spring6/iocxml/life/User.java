package com.atguigu.spring6.iocxml.life;

public class User {
    private String name;
    private User(){
        System.out.println("1.调用无参数构造");
    }
    //初始化方法
    public void initMethod(){
        System.out.println("4.初始化方法");
    }
    //销毁方法
    public void destroyMethod(){
        System.out.println("7.销毁方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("2.给bean对象设置属性值");
        this.name = name;
    }
}
