package com.whchao.demo.config.service;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;

@Configuration
@EnableWebSocketMessageBroker
//通过@EnableWebSocketMessageBroker 注解凯旗使用STOMP协议来传输基于代理（message broker）的消息
//这时控制器支持使用@MessageMapping，就像使用@RequestMapping一样
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/endpoint").withSockJS();//注册STOMP协议的节点，映射指定的URL，并指定使用SockJS协议
    }


    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {//配置消息代码（Message Broker）
        registry.enableSimpleBroker("/topic");//广播式应配置一个/topic消息代理
    }
}
