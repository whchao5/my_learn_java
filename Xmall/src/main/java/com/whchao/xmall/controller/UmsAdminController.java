package com.whchao.xmall.controller;

import com.whchao.xmall.common.api.ResponseResult;
import com.whchao.xmall.dto.UmsAdminLoginParam;
import com.whchao.xmall.mbg.model.UmsAdmin;
import com.whchao.xmall.mbg.model.UmsPermission;
import com.whchao.xmall.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(tags = "UmsAdminController", description = "后台用户管理")
@RequestMapping("/admin")
public class UmsAdminController {
    @Autowired
    private UmsAdminService adminService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<UmsAdmin> register(@RequestBody UmsAdmin umsAdminParam, BindingResult result) {
        UmsAdmin umsAdmin = adminService.register(umsAdminParam);
        if (umsAdmin == null) {
            ResponseResult.failed();
        }

        return ResponseResult.success(umsAdmin);
    }

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult result) {
        String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            ResponseResult.failed();
        }

        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return ResponseResult.success(tokenMap);
    }
//    {"password" : "123456","username" : "test"}  Bearer token


    @ApiOperation("获取用户所有权限（包括+-权限）")
    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult<List<UmsPermission>> permission(@PathVariable Long adminId) {
        List<UmsPermission> permissionList = adminService.getPermissionList(adminId);

        return ResponseResult.success(permissionList);
    }


}
