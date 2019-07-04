package com.whchao.demo.webservices;

import com.whchao.demo.webservices.type.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IndexController {

    @Autowired
    private WsClient wsClient;


    @RequestMapping("callws")
    public Object callWs() {
        GetCountryResponse response = wsClient.getCountry("hello");
        return response.getCountry();
    }

    @RequestMapping("callws_object")
    public Object callWsObject() {
        Object response = wsClient.getCountryObject("hello");
        return response;
    }
}
