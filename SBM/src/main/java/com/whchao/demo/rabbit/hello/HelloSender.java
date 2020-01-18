package com.whchao.demo.rabbit.hello;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String content = "hello " + new Date();
        System.out.println("Sender: " + content);
        this.rabbitTemplate.convertAndSend("hello", content);
    }
}
