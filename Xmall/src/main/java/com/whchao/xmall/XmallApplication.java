package com.whchao.xmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.whchao.xmall.dao")
public class XmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(XmallApplication.class, args);
    }

}
