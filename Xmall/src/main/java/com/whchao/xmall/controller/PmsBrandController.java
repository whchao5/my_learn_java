package com.whchao.xmall.controller;


import com.whchao.xmall.service.PmsBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brand")
public class PmsBrandController {

    private static final Logger logger = LoggerFactory.getLogger(PmsBrandController.class);


    @Autowired
    private PmsBrandService pmsBrandService;


//    @RequestMapping("/listAll")
//
}
