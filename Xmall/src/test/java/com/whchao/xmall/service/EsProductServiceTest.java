package com.whchao.xmall.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsProductServiceTest {


    @Resource
    private EsProductService productService;


    @Test
    public void TestListAllBrand() {

        System.out.println(productService.importAll());
    }
    @Test
    public void TestSearch() {

        System.out.println(productService.search("华为", 1, 3).toString());
    }
}
