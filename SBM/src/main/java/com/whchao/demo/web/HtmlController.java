package com.whchao.demo.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/html")
public class HtmlController {

    @RequestMapping(value = "/index")
    private String index() {
        return "index";
    }
}
