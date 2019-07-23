package com.whchao.demo.dao;

import com.whchao.demo.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoDao extends CrudRepository<UserInfo,Long>  {


    /**通过username查找用户信息;*/
    UserInfo findByUsername(String username);
}
