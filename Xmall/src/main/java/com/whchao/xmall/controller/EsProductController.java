package com.whchao.xmall.controller;


import com.whchao.xmall.common.api.ResponsePage;
import com.whchao.xmall.common.api.ResponseResult;
import com.whchao.xmall.nosql.elasticsearch.document.EsProduct;
import com.whchao.xmall.service.EsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Api(tags = "EsProductController", description = "搜索商品管理")
@RequestMapping("/esProduct")
public class EsProductController {

    @Resource
    private EsProductService esProductService;


    @ApiOperation(value = "导入所有数据库中商品到ES")
    @RequestMapping(value = "/importAll", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<Integer> importAll() {
        int count = esProductService.importAll();
        return ResponseResult.success(count);
    }

    @ApiOperation(value = "根据id删除商品")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult<Object> delete(@PathVariable Long id) {
         esProductService.delete(id);
        return ResponseResult.success(null);
    }

    @ApiOperation(value = "根据id删除商品")
    @RequestMapping(value = "/delete/batch", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<Object> delete(@RequestParam("ids") List<Long> ids) {
        esProductService.delete(ids);
        return ResponseResult.success(null);
    }

    @ApiOperation(value = "根据id创建商品")
    @RequestMapping(value = "/create/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult<EsProduct> create(@PathVariable Long id) {
        EsProduct esProduct = esProductService.create(id);
        if (esProduct != null) {
            return ResponseResult.success(esProduct);
        }
        return ResponseResult.failed();
    }


    @ApiOperation(value = "简单搜索")
    @RequestMapping(value = "/search/simple", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult<ResponsePage<EsProduct>> search(@RequestParam(required = false) String keyword,
                                                          @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                          @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Page<EsProduct> esProductPage = esProductService.search(keyword, pageNum, pageSize);

        return ResponseResult.success(ResponsePage.restPage(esProductPage));
    }
}
