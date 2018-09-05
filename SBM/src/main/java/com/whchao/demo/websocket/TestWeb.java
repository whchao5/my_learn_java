package com.whchao.demo.websocket;

import com.whchao.demo.service.MessageAcceptor;
import com.whchao.demo.service.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


@Controller
@RequestMapping("/websocket")
public class TestWeb {


    @Autowired
    private SimpMessagingTemplate messagingTemplate;//spring实现的一个发送模板类

    @MessageMapping(value = "/message/test")//当浏览器向服务端发送请求时，通过@MessageMapping映射的地址，类似于@RequestMapping
    @SendTo(value = "/topic/response")//当服务端有消息时，会对订阅了@SendTo中的路径的浏览器发送消息
    public MessageSender say(MessageAcceptor acceptor){
        return new MessageSender("HELLO!"+acceptor.getMsg());
    }

    @MessageMapping("/chat")
    public void handlerChat(Principal principal, String msg) {//springmvc中可以直接在参数中获得pricipal，pricipal中包含当前永不的信息
        if (principal.getName().equalsIgnoreCase("muxiao")) {
            messagingTemplate.convertAndSendToUser("hahaha","/queue/notice",principal.getName()+":"+msg);
        } else {
            messagingTemplate.convertAndSendToUser("muxiao","/queue/notice",principal.getName()+":"+msg);
            //通过messaginTemplate.converAndSendTiUser向用户发送消息，第一次参数是接受信息的用户，第二个是浏览器订阅的地址，第三个是消息本身
        }
    }

    @RequestMapping("/index")
    public String index(){
        return "websocket/websocket";
    }


    @RequestMapping("/chat")
    public String index_two(){
        return "websocket/chat";
    }

//    @RequestMapping("/login")
//    public String login(){
//        return "websocket/login";
//    }

}
