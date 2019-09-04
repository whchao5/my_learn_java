package com.whchao.xmall.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.whchao.xmall.mbg.mapper")
public class MyBatisConfig {
}
