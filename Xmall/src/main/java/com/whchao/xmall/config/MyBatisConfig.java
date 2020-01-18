package com.whchao.xmall.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan({
        "com.whchao.xmall.mbg.mapper",
        "com.macro.mall.mapper",
        "com.macro.mall.dao"
})
public class MyBatisConfig {
}
