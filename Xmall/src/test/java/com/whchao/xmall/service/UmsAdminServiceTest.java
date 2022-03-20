package com.whchao.xmall.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UmsAdminServiceTest {

    @Autowired
    private UmsAdminService adminService;

    @Test
    public void TestGetAdminByUsername() {
        System.out.println(adminService.getAdminByUsername("test"));
    }

    @Test
    public void login() {
        System.out.println(adminService.login("test", "123456"));
    }

    @Test
    public void PermissionListTest() {
        System.out.println(adminService.getPermissionList(3L));
    }
}
