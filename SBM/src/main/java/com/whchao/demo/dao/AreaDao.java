package com.whchao.demo.dao;

import com.whchao.demo.entity.Area;

import java.util.List;

public interface AreaDao {

    /**
     * 列出区域列表
     *
     * @return areaList
     */
    List<Area> queryArea();

    /**
     * 根据Id列出具体区域
     *
     * @return area
     */
    Area queryAreaById(int id);


    int insertArea(Area area);


    /**
     * 更新区域信息
     *
     * @param area
     * @return
     */
    int updateArea(Area area);

    /**
     * 删除区域信息
     *
     * @param id
     * @return
     */

    int deleteArea(int id);

}


