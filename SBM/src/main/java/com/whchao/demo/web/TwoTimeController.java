package com.whchao.demo.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class TwoTimeController {

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String say() {
        return "index";
    }


//    http://localhost:8082/admin/path/5s
    @RequestMapping(value = "/path/{id}", method = RequestMethod.GET)
    public String path(@PathVariable("id") Integer id) {
        return "id: " + id;
    }

}
