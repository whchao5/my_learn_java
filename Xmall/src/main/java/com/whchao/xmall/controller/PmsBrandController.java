package com.whchao.xmall.controller;


import com.whchao.xmall.common.api.Response;
import com.whchao.xmall.mbg.model.PmsBrand;
import com.whchao.xmall.service.PmsBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

        if (result.hasErrors()) {
            return Response.failed("no");
        }

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

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Response updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrandDto, BindingResult result) {
        Response response;

        logger.info(pmsBrandDto.toString());
        int count = pmsBrandService.updateBrand(id, pmsBrandDto);
        if (count == 1) {
            response = Response.success(pmsBrandDto);
            logger.debug("updateBrand success:{}", pmsBrandDto);
        } else {
            response = Response.failed("操作失败");
            logger.debug("updateBrand failed:{}", pmsBrandDto);
        }
        return response;
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Response deleteBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize,
                                BindingResult result) {
        return Response.success(pmsBrandService.listBrand(pageNum, pageSize));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Response listBrand(@PathVariable("id") Long id,  BindingResult result) {

        return Response.success(pmsBrandService.listAllBrand());
    }
}
