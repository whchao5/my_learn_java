package com.whchao.demo.dao;

import com.whchao.demo.entity.Girls;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class GirlsDaoTest {

    @Autowired
    private GirlsDao girlsDao;

    @Test
    public void queryGirl() {
        List<Girls> list = girlsDao.queryGirl();
        System.out.println(list);
        assertEquals(false, list.isEmpty());
    }


    @Test
    public void queryGirlById() {
        Girls girl = girlsDao.queryGirlsById(2);
        System.out.println(girl);
        assertEquals(2, girl.getId().intValue());
    }

    @Test
    public void insertArea() {
        // 创建一个区域
        Girls girl = new Girls();
        girl.setName("keowws");
        girl.setAge(14);

        int effectedNum = girlsDao.insertGirls(girl);
        System.out.println(effectedNum);

        assertEquals(1, effectedNum);
    }

}
