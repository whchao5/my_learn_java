package com.whchao.demo.webservices.client;


import com.whchao.demo.webservices.service.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/soap")
public class IndexController {

//    @Autowired
//    private CountryClient  wsClient;
//
//
//    @RequestMapping("callws")
//    public Object callWs() {
//        GetCountryResponse response = wsClient.getCountry("hello");
//        return response.getCountry();
//    }
}
