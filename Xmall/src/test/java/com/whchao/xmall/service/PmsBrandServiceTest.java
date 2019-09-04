package com.whchao.xmall.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PmsBrandServiceTest {

    @Resource
    private PmsBrandService pmsBrandService;

    @Test
    public void TestListAllBrand() {
        System.out.println(pmsBrandService.listAllBrand());
    }
}
