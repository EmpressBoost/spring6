package com.atguigu.spring6.bean.junit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
/*方法一
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:bean.xml")*/
//方法2
@SpringJUnitConfig(locations = "classpath:bean.xml")
public class SpringTestJunit5 {

    @Autowired
    private User user;

    @Test
    public void testUser(){
        System.out.println(user);
        user.run();
    }
}
