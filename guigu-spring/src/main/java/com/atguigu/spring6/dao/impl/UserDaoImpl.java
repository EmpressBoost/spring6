package com.atguigu.spring6.dao.impl;

import com.atguigu.spring6.anno.Bean;
import com.atguigu.spring6.dao.UserDao;

@Bean
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("dao.......");
    }
}
