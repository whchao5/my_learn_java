package com.whchao.demo.rabbit.hello;


//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class MySender {
//    private static Logger log = LoggerFactory.getLogger(MySender.class);
//
//    @Autowired
//    private AmqpTemplate rabbitTemplate;
//
//    public void send() {
//        String content = "hello " + new Date();
//        log.info("my_queue: " + content);
//        this.rabbitTemplate.convertAndSend("my_queue", content);
//    }
//}
//
