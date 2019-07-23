package com.whchao.demo.service.impl;

import com.whchao.demo.dao.UserInfoDao;
import com.whchao.demo.entity.UserInfo;
import com.whchao.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {


    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");

        return userInfoDao.findByUsername(username);
    }
}
