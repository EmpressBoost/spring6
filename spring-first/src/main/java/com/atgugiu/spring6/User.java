package com.atgugiu.spring6;

public class User {

    public void add(){
        System.out.println("add....");
    }
    public User(){
        System.out.println("无参数构造已经执行了");
    }


    public static void main(String[] args) {
        User user = new User();
        user.add();
    }
}
