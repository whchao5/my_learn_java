package com.whchao.demo.dao;

import com.whchao.demo.entity.Area;
import com.whchao.demo.entity.UserInfo;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;

    @Autowired
    private UserInfoDao userInfoDao;

    @Test
    public void queryArea() {
        List<Area> areaList = areaDao.findAll();
        System.out.println(areaList);

//         验证预期值和实际值是否相符
//        assertEquals(false, areaList.isEmpty());
    }
//
    @Test
    public void queryAreaById() {
        Area area = areaDao.findByName("chaoge");
        System.out.println(area);

//        assertEquals(1, area.getName());
//        assertEquals(1, area.getId().intValue());
    }
//
//    @Test
//    public void insertArea() {
//        // 创建一个区域
//        Area area = new Area();
//        area.setName("测试区域4");
//        area.setCreateTime(new Date());
//        area.setPriority(1);
//
////        int effectedNum = areaDao.save(area);
//        System.out.println(areaDao.save(area));
//
////        assertEquals(1, effectedNum);
//    }
//
//    @Test
////    @Ignore
//    public void updateArea() {
//
//        List<Area> areaList = areaDao.queryArea();
//
//        for (Area e : areaList) {
//            if ("测试区域".equals(e.getName())) {
//                assertEquals(1, e.getPriority().intValue());
//                e.setPriority(2);
//
//                int effectedNum = areaDao.updateArea(e);
//                assertEquals(1, effectedNum);
//            }
//        }
//    }
//
//    @Test
//    public void deleteArea() {
//
//        List<Area> areaList = areaDao.queryArea();
//
//        for (Area e : areaList) {
//            if ("测试区域".equals(e.getName())) {
//
//                int effectedNum = areaDao.deleteArea(e.getId());
//                assertEquals(1, effectedNum);
//            }
//        }
//        areaList = areaDao.queryArea();
//        assertEquals(false, areaList.isEmpty());
//
//    }
//
//
//    @Test
//    public void queryByName() {
//        Area area = areaDao.findByName("东北");
//        System.out.println(area);
//
////        assertEquals(1, area.getName());
//        assertEquals(1, area.getId().intValue());
//    }


    @Test
    public void queryUserInfo() {
        UserInfo area = userInfoDao.findByUsername("admin");
        System.out.println(area.toString());

//        assertEquals(1, area.getName());
        assertEquals(1, area.getUid().intValue());
    }
}