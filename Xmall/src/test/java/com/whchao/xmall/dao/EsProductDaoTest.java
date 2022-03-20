package com.whchao.xmall.dao;


import com.whchao.xmall.service.EsProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsProductDaoTest {


    @Resource
    private EsProductDao productDao;


    @Test
    public void TestGetAllEsProductList() {

        System.out.println(productDao.getAllEsProductList(null));
    }
}
