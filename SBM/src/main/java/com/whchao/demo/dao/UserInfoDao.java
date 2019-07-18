package com.whchao.demo.dao;

import com.whchao.demo.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoDao {

    UserInfo findByUsername(String username);
}
