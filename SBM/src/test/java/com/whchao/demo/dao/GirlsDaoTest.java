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


//    @Test
//    public void queryGirlById() {
//        Girls girl = girlsDao.queryGirlsById(1);
//        System.out.println(girl);
////        assertEquals(1, area.getName());
//        assertEquals(1, girl.getGirl_id().intValue());
//    }

}
