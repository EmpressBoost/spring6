package com.atguigu.spring6.iocxml.auto.service;

import com.atguigu.spring6.iocxml.auto.dao.UserDao;
import com.atguigu.spring6.iocxml.auto.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUerService() {
        System.out.println("UserServiceImpl.....执行了");
        UserDao userDao = new UserDaoImpl();
        userDao.addUserDao();
    }
}
