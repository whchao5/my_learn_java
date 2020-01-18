package com.whchao.xmall.service;

import com.whchao.xmall.common.api.ResponseResult;

public interface UmsMemberService {

    /**
     * 生成验证码
     */
    ResponseResult generateAuthCode(String telephone);


    /**
     * 判断验证码和手机号码是否匹配
     */
    ResponseResult verifyAuthCode(String telephone, String authCode);

}
