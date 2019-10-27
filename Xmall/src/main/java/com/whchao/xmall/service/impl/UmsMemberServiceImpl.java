package com.whchao.xmall.service.impl;

import com.whchao.xmall.common.api.ResponseResult;
import com.whchao.xmall.service.RedisService;
import com.whchao.xmall.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private RedisService redisService;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;


    /**
     * 生成验证码
     */
    public ResponseResult generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);

        return ResponseResult.success(sb.toString(), "获取验证码成功");
    }


    /**
     * 判断验证码和手机号码是否匹配
     */
    public ResponseResult verifyAuthCode(String telephone, String authCode) {
        if (StringUtils.isEmpty(authCode)) {
            return ResponseResult.failed("请输入验证码");
        }

        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        boolean result = realAuthCode.equals(authCode);
        if (result) {
            return ResponseResult.success("验证码检验成功");
        }
        return ResponseResult.failed("验证码不正确");
    }
}
