package com.whchao.xmall.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.whchao.xmall.mbg.model.PmsBrand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PmsBrandServiceTest {

    @Resource
    private PmsBrandService pmsBrandService;

    @Test
    public void TestListAllBrand() {

        System.out.println(pmsBrandService.listAllBrand());
    }

    @Test
    public void TestCreateBrand() {

        PmsBrand brand = new PmsBrand();

        brand.setName("霸气");
        brand.setFirstLetter("B");
        brand.setSort(100);
        brand.setFactoryStatus(100);
        brand.setShowStatus(100);
        brand.setProductCount(100);
        brand.setProductCommentCount(100);
        brand.setLogo("http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/timg (51).jpg");
        brand.setBrandStory("飞起");

        System.out.println(pmsBrandService.createBrand(brand));
    }

    @Test
    public void TestUpdateBrand() {

        Long id = 61L;


        PmsBrand brand = new PmsBrand();

        brand.setName("霸气_update");

        System.out.println(pmsBrandService.updateBrand(id, brand));
    }

    @Test
    public void TestDeleteBrand() {

        Long id = 66L;
        System.out.println(pmsBrandService.deleteBrand(id));
    }

    @Test
    public void TestListBrand() {


        List<PmsBrand> brands = pmsBrandService.listBrand(0,3);

        System.out.println(brands);
        System.out.println(( (Page)brands).getTotal());

        PageInfo page = new PageInfo(brands);
        System.out.println(page.getTotal());

//        System.out.println(brands.get(2));

        // Creating Object of ObjectMapper define in Jakson Api
        ObjectMapper Obj = new ObjectMapper();

        try {
            System.out.println(Obj.writeValueAsString(pmsBrandService.listBrand(0,3)));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void TestGetBrand() {

        System.out.println(pmsBrandService.getBrand(1L));
    }




}
