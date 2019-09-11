package com.whchao.xmall.controller;


import com.whchao.xmall.common.api.ResponsePage;
import com.whchao.xmall.common.api.ResponseResult;
import com.whchao.xmall.mbg.model.PmsBrand;
import com.whchao.xmall.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 品牌管理Controller
 * Created by macro on 2019/4/19.
 */

@Api(tags = "PmsBrandController", description = "商品品牌管理")
@Controller
@RequestMapping("/brand")
public class PmsBrandController {

    private static final Logger logger = LoggerFactory.getLogger(PmsBrandController.class);


    @Autowired
    private PmsBrandService pmsBrandService;

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult<List<PmsBrand>> getListAll() {

        return ResponseResult.success(pmsBrandService.listAllBrand());
    }

    @ApiOperation("获取所有品牌列表")
    @RequestMapping(value = "/createBrand", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult createBrand(@RequestBody PmsBrand pmsBrand, BindingResult result) {
        ResponseResult responseResult;

        if (result.hasErrors()) {
            return ResponseResult.failed("no");
        }

        logger.info(pmsBrand.toString());
        int count = pmsBrandService.createBrand(pmsBrand);
        if (count == 1) {
            responseResult = ResponseResult.success(pmsBrand);
            logger.debug("createBrand success:{}", pmsBrand);
        } else {
            responseResult = ResponseResult.failed("操作失败");
            logger.debug("createBrand failed:{}", pmsBrand);
        }
        return responseResult;
    }

    @ApiOperation("添加品牌")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrandDto, BindingResult result) {
        ResponseResult responseResult;

        logger.info(pmsBrandDto.toString());
        int count = pmsBrandService.updateBrand(id, pmsBrandDto);
        if (count == 1) {
            responseResult = ResponseResult.success(pmsBrandDto);
            logger.debug("updateBrand success:{}", pmsBrandDto);
        } else {
            responseResult = ResponseResult.failed("操作失败");
            logger.debug("updateBrand failed:{}", pmsBrandDto);
        }
        return responseResult;
    }


    @ApiOperation("删除指定id的品牌")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult deleteBrand(@PathVariable("id") Long id, BindingResult result) {
        ResponseResult responseResult;
        int            count = pmsBrandService.deleteBrand(id);
        if (count == 1) {
            responseResult = ResponseResult.success(id);
            logger.debug("updateBrand success:{}", id);
        } else {
            responseResult = ResponseResult.failed("操作失败");
            logger.debug("updateBrand failed:{}", id);
        }
        return responseResult;
    }

    @ApiOperation("分页查询品牌列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {

        List<PmsBrand> brandList = pmsBrandService.listBrand(pageNum, pageSize);
        logger.info("pageNum => {}, pageSize => {}, brandList => {}", pageNum, pageSize, brandList);

        return ResponseResult.success(ResponsePage.restPage(brandList));
    }


    @ApiOperation("获取指定id的品牌详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult getBrand(@PathVariable(value = "id") Long id) {

        PmsBrand brandList = pmsBrandService.getBrand(id);
        return ResponseResult.success(brandList);
    }
}
