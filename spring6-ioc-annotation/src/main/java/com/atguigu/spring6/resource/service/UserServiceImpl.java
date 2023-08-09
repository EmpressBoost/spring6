package com.atguigu.spring6.resource.service;

import com.atguigu.spring6.resource.dao.UserDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("myUserservice")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao myUserDao;

    @Override
    public void addv() {
        System.out.println("UserServiceImpl....");
        myUserDao.add();
    }
}
