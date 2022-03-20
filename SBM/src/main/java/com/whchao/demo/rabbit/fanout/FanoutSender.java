package com.whchao.demo.rabbit.fanout;


//import com.whchao.demo.rabbit.hello.NeoSender;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class FanoutSender {
//
//    private static Logger log = LoggerFactory.getLogger(FanoutSender.class);
//
//    @Autowired
//    private AmqpTemplate rabbitTemplate;
//
//
//    public void send(int i) {
//        String context = "hi, fanout msg " + " ****** " + i;
//
////        System.out.println("Sender 1 - " + i + ": " + context);
//        log.info("Sender : " + context);
//
//        this.rabbitTemplate.convertAndSend("fanoutExchange","", context);
//    }
//}
