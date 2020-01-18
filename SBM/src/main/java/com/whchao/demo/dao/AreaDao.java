package com.whchao.demo.dao;

import com.whchao.demo.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.List;


//public interface AreaDao extends CrudRepository<Area, Long> {
    public interface AreaDao  extends JpaSpecificationExecutor<Area>,JpaRepository<Area,Integer> {

    /**
     * 列出区域列表
     *
     * @return areaList
     */
    @Query(value = "SELECT id, name, priority, create_time, last_edit_time FROM area ORDER BY priority DESC", nativeQuery = true)
    List<Area> queryArea();


    List<Area> findAll();

    Area findByName(String name);

    Area findById(int name);

//    save(Area area);

    /**
     * 根据Id列出具体区域
     *
     * @return area
     */
    //        @Query(value = "SELECT id, name, priority,create_time, last_edit_time FROM area WHERE id = ?1", nativeQuery = true)
    //        public Area queryAreaById(int id);


    //    int insertArea(Area area);


    /**
     * 更新区域信息
     *
     * @param area
     * @return
     */

    /**
     * 删除区域信息
     *
     * @param id
     * @return
     */

    //    int deleteArea(int id);


    //    public Area findByName(String name);

}


