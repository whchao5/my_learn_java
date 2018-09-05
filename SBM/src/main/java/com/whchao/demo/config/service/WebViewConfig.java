package com.whchao.demo.config.service;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by lenovo on 2017/3/17.
 */
@Configuration
public class WebViewConfig extends WebMvcConfigurerAdapter  {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/chat").setViewName("/chat");
        registry.addViewController("/login").setViewName("/login");
    }
}
