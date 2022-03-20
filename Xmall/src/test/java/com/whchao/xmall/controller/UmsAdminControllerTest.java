package com.whchao.xmall.controller;


import com.whchao.xmall.common.api.ResponseResult;
import com.whchao.xmall.dto.UmsAdminLoginParam;
import com.whchao.xmall.mbg.model.UmsPermission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UmsAdminControllerTest {


    @Autowired
    private UmsAdminController adminController;


    //    https://juejin.im/post/5b88b1dbf265da435743accf
    @Test
    public void restTemplateGetTest(){
        RestTemplate restTemplate = new RestTemplate();
        Map notice = restTemplate.getForObject("http://localhost:8084/admin/permission/3"
                , Map.class);
        System.out.println(notice);
    }


    @Test
    public void restTemplateGetOkTest(){
        ResponseResult<List<UmsPermission>> result = adminController.permission(3L);
        System.out.println(result.getData());
    }


    @Test
    public void loginTest(){
        UmsAdminLoginParam adminLoginParam = new UmsAdminLoginParam();
        adminLoginParam.setPassword("123456");
        adminLoginParam.setUsername("test");


        ResponseResult result = adminController.login(adminLoginParam, null);
        System.out.println(result.getData());
    }

}
