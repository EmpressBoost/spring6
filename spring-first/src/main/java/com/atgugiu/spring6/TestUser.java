package com.atgugiu.spring6;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    private Logger logger = LoggerFactory.getLogger(TestUser.class);

    @Test
    public void testUserObject(){
        //加载spring配置文件，对象创建

        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //获取创建的对象
        User user = (User) context.getBean("user");
        System.out.println("1:"+user);
        //使用对象调用方法进行测试
        System.out.println("2:");
        user.add();

        logger.info("####执行调用成功了。。。。");
    }

    @Test
    public void testUserObject1() throws Exception {
        Class<?> clazz = Class.forName("com.atgugiu.spring6.User");


        User user = (User)clazz.getDeclaredConstructor().newInstance();

        System.out.println("1:"+user);
    }
}
