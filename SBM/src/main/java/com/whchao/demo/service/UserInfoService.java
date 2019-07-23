package com.whchao.demo.service;


import com.whchao.demo.entity.UserInfo;

public interface UserInfoService {

    public UserInfo findByUsername(String username);
}
