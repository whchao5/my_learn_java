package com.whchao.xmall.controller;


import com.whchao.xmall.common.api.Response;
import com.whchao.xmall.mbg.model.PmsBrand;
import com.whchao.xmall.service.PmsBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/brand")
public class PmsBrandController {

    private static final Logger logger = LoggerFactory.getLogger(PmsBrandController.class);


    @Autowired
    private PmsBrandService pmsBrandService;


    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public Response<List<PmsBrand>> getListAll() {

        return Response.success(pmsBrandService.listAllBrand());
    }



    @RequestMapping(value = "/createBrand", method = RequestMethod.POST)
    @ResponseBody
    public Response createBrand(@RequestBody PmsBrand pmsBrand, BindingResult result) {
        Response response;

        logger.info(pmsBrand.toString());
        int count = pmsBrandService.createBrand(pmsBrand);
        if (count == 1) {
            response = Response.success(pmsBrand);
            logger.debug("createBrand success:{}", pmsBrand);
        } else {
            response = Response.failed("操作失败");
            logger.debug("createBrand failed:{}", pmsBrand);
        }
        return response;
    }
}
