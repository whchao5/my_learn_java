package com.whchao.demo.rabbit.hello;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//@Component
//@RabbitListener(queues = "hello")
//public class HelloReceiver {
//
//    private static Logger log = LoggerFactory.getLogger(HelloReceiver.class);
//
//    @RabbitHandler
//    public void process(String hello) {
//
////        System.out.println("Receiver : " + hello);
//        log.info("Receiver : " + hello);
//
//    }
//}
