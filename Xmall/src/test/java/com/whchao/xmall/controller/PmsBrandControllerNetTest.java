package com.whchao.xmall.controller;


import com.mysql.cj.protocol.x.Notice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PmsBrandControllerNetTest {



    //    https://juejin.im/post/5b88b1dbf265da435743accf
    @Test
    public void restTemplateGetTest(){
        RestTemplate restTemplate = new RestTemplate();
        Map notice = restTemplate.getForObject("http://localhost:8084/brand/listAll"
                , Map.class);
        System.out.println(notice);
    }

}
