package com.atguigu.spring6.service.impl;

import com.atguigu.spring6.anno.Bean;
import com.atguigu.spring6.anno.Di;
import com.atguigu.spring6.dao.UserDao;
import com.atguigu.spring6.service.UserService;

@Bean
public class UserServiceImpl implements UserService {

    @Di
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("Service....");
        userDao.add();
    }
}
