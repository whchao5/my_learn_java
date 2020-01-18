package com.whchao.demo.dao;


import com.whchao.demo.entity.SysRole;
import com.whchao.demo.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoDaoTest {


    @Autowired
    private UserInfoDao userInfoDao;

    @Test
    public void queryUserInfo() {
        UserInfo area = userInfoDao.findByUsername("admin");
        System.out.println(area.toString());
        System.out.println(area.getRoleList());
        for (SysRole sr : area.getRoleList()) {

            System.out.println(sr.getId());
        }

        //        assertEquals(1, area.getName());
        assertEquals(1, area.getUid().intValue());
    }
}
