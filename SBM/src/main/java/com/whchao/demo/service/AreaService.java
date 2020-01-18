package com.whchao.demo.service;


import com.whchao.demo.entity.Area;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AreaService {

    /**
     * 列表
     * @return
     */
    List<Area> getAreaList();

    /**
     * 获取
     * @param id
     * @return
     */
    Area getAreaById(int id);

    /**
     * 添加
     * @param area
     * @return
     */
    boolean addArea(Area area);

    /**
     * 修改
     * @param area
     * @return
     */
    boolean modifyArea(Area area);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean deleteArea(int id);

}
