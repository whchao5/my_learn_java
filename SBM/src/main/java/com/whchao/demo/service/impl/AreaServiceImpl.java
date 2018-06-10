package com.whchao.demo.service.impl;

import com.whchao.demo.dao.AreaDao;
import com.whchao.demo.entity.Area;
import com.whchao.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int id) {
        return areaDao.queryAreaById(id);
    }

    @Override
    public boolean addArea(Area area) {

        if (area.getName() != null && !"".equals(area.getName())) {
            area.setLastEditTime(new Date());

            try {
                int effectedNum = areaDao.insertArea(area);

                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("添加区错误");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加区域信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean modifyArea(Area area) {

        if (area.getId() != null && area.getId() > 0) {
            area.setLastEditTime(new Date());

            try {
                // 更新区域信息
                int effectedNum = areaDao.updateArea(area);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新区域信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新区域信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean deleteArea(int id) {
        if (id > 0) {

            try {
                int effectedNum = areaDao.deleteArea(id);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除区域信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除区域信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("区域Id不能为空！");
        }
    }
}
