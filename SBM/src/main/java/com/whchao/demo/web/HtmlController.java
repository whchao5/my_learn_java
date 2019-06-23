package com.whchao.demo.web;


import com.whchao.demo.config.handler.CustomException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/html")
public class HtmlController {

    @RequestMapping(value = "/index")
    private String index() {
        return "index";
    }

    //http://localhost:8082/html/custom?name=00d
    @RequestMapping(value = "/custom")
    public String Custom(String name) {

        if (name == null) {
            throw new CustomException(305, "bug");
        }

        return name;
    }
}
