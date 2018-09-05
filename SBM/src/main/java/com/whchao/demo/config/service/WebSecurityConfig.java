package com.whchao.demo.config.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 权限管理配置构造器
     *
     * @param auth 权限管理
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //配置了两个用户和对应的密码，并且申明了他们的角色
        auth.inMemoryAuthentication().withUser("muxiao").password("123456").roles("USER")
                .and().withUser("hahaha").password("123456").roles("USER");//在内存中分别配置两个用户muxiao和hahaha

    }


    /**
     * Web安全配置
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        //静态资源不做安全校验
        web.ignoring().antMatchers("/resources/static/**");///resources/static/目录下的静态资源，不拦截
    }

    /**
     * 配置http安全
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //简单的配置运行点对点所需要的登陆权限
        http.authorizeRequests()
                .antMatchers("/","login").permitAll()//设置Spring Security对/和/login路径不拦截
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login")//设置登录页面访问的路径为/login
                .defaultSuccessUrl("/chat").permitAll()//登陆成功后转向chat页面
                .and().logout().permitAll();
    }
}
