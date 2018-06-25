package com.whchao.demo.dao;

import com.whchao.demo.entity.Girls;

import java.util.List;

public interface GirlsDao {

    /**
     * 列出区域列表
     *
     * @return girlsList
     */
    List<Girls> queryGirl();

    /**
     * 根据Id列出具体区域
     *
     * @return Girls
     */
//    Girls queryGirlsById(int girl_id);


//    int insertGirls(Girls girl);


    /**
     * 更新区域信息
     *
     * @param area
     * @return
     */
//    int updateGirls(Girls area);

    /**
     * 删除区域信息
     *
     * @param id
     * @return
     */

//    int deleteGirls(int id);
}
