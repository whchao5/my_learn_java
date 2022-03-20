package com.whchao.xmall.service.impl;

import com.whchao.xmall.common.utils.JwtTokenUtil;
import com.whchao.xmall.dao.UmsAdminRoleRelationDao;
import com.whchao.xmall.mbg.mapper.UmsAdminMapper;
import com.whchao.xmall.mbg.model.UmsAdmin;
import com.whchao.xmall.mbg.model.UmsAdminExample;
import com.whchao.xmall.mbg.model.UmsPermission;
import com.whchao.xmall.service.UmsAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    private static final Logger                  LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);
    @Resource
    private              UmsAdminMapper          adminMapper;
    @Autowired
    private              PasswordEncoder         passwordEncoder;
    @Autowired
    private              UserDetailsService      userDetailsService;
    @Autowired
    private              JwtTokenUtil            jwtTokenUtil;
    @Resource
    private              UmsAdminRoleRelationDao adminRoleRelationDao;


    /**
     * 根据用户名获取后台管理员
     */
    @Override
    public UmsAdmin getAdminByUsername(String username) {

        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);

        List<UmsAdmin> adminList = adminMapper.selectByExample(example);

        if (adminList != null && adminList.size() > 0) {
            return adminList.get(0);
        }
        return null;
    }


    /**
     * 注册功能
     */
    @Override
    public UmsAdmin register(UmsAdmin umsAdminParam) {

        UmsAdmin umsAdmin = new UmsAdmin();

        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);

        //查询是否有相同用户名的用户
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(umsAdmin.getUsername());
        List<UmsAdmin> umsAdmins = adminMapper.selectByExample(example);
        if (umsAdmins.size() > 0) {
            return null;
        }

        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        adminMapper.insert(umsAdmin);

        return umsAdmin;
    }

    /**
     * 登录功能
     *
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
                    null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;

    }

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    @Override
    public List<UmsPermission> getPermissionList(Long adminId) {
        return adminRoleRelationDao.getPermissionList(adminId);
    }

}
