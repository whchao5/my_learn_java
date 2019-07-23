package com.whchao.demo.service;


import com.whchao.demo.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoServiceTest {


    @Resource
    private UserInfoService userInfoService;

    @Test
    public void findByNameuser() {
        UserInfo userInfo = userInfoService.findByUsername("admin");

        System.out.println(userInfo);
    }
}
