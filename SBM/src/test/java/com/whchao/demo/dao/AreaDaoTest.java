package com.whchao.demo.dao;

import com.whchao.demo.entity.Area;
import com.whchao.demo.entity.UserInfo;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;


    @Test
    public void queryArea() {
//        List<Area> areaList = areaDao.findAll();
        List<Area> areaList = areaDao.queryArea();
        System.out.println(areaList);

//         验证预期值和实际值是否相符
        assertEquals(false, areaList.isEmpty());
    }
//
    @Test
    public void queryAreaById()  {
        Area area = areaDao.findByName("chaoge");
        System.out.println(area);

        assertEquals(1, area.getId().intValue());
    }
//
    @Test
    public void insertArea() throws Exception {
        // 创建一个区域
        Area area = new Area();
        area.setName("测试区域");
        area.setCreateTime(new Date());
        area.setLastEditTime(new Date());
        area.setPriority(1);

        System.out.println( areaDao.save(area));

//        assertEquals(1, effectedNum);
    }

    @Test
//    @Ignore   // 测试方法将被忽略，不被执行
    public void updateArea() {

        List<Area> areaList = areaDao.findAll();

        for (Area e : areaList) {
            if ("测试区域".equals(e.getName())) {
                assertEquals(1, e.getPriority().intValue());
                e.setPriority(2);

                Area it=  areaDao.save(e);
                assertEquals(2, it.getPriority().intValue());
            }
        }
    }

    @Ignore
    @Test
    @Transactional
    public void deleteArea() {

        List<Area> areaList = areaDao.queryArea();

        for (Area e : areaList) {
            if ("测试区域".equals(e.getName())) {

                System.out.println(e.getId());
                areaDao.deleteById(e.getId());
//                assertEquals(false, effectedNum);
            }
        }
        areaList = areaDao.queryArea();
        assertEquals(false, areaList.isEmpty());

    }


    @Test
    public void queryByName() {
        Area area = areaDao.findByName("东北");
        System.out.println(area);

//        assertEquals(1, area.getName());
        assertEquals(1, area.getId().intValue());
    }



}