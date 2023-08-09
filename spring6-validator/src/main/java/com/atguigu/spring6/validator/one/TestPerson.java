package com.atguigu.spring6.validator.one;

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

public class TestPerson {
    public static void main(String[] args) {
        //1.创建person对象
        Person person = new Person();
        person.setName("lucy");
        person.setAge(250);
        //2.创建person对应的databiner对象
        DataBinder binder = new DataBinder(person);
        //3.设置校验器
        binder.setValidator(new PersonValidator());
        //4.调用方法执行校验
        binder.validate();
        //5.输出校验结果
        BindingResult result = binder.getBindingResult();
        System.out.println(result.getAllErrors());
    }
}
