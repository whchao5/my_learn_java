package com.whchao.xmall.controller;

import com.whchao.xmall.common.api.ResponseResult;
import com.whchao.xmall.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


/**
 * 会员登录注册管理Controller
 * Created by macro on 2018/8/3.
 */
@Controller
@Api(tags = "UmsMemberController", description = "会员注册中心")
@RequestMapping("/sso")
public class UmsMemberController {


    @Autowired
    private UmsMemberService umsMemberService;

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult getAuthCode(@RequestParam String telephone) {

        return umsMemberService.generateAuthCode(telephone);
    }

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/verifyAuthCode", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult verifyAuthCode(@RequestParam String telephone
            , @RequestParam String authCode) {

        return umsMemberService.verifyAuthCode(telephone, authCode);
    }
}
