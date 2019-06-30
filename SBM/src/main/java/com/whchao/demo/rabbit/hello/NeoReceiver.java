package com.whchao.demo.rabbit.hello;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "neo")
public class NeoReceiver {

    private static Logger log = LoggerFactory.getLogger(NeoReceiver.class);

    @RabbitHandler
    public void process(String neo) {
//        System.out.println("Receiver : " + neo);
        log.info("Receiver 1-: " + neo);
//        System.out.println("Receiver 1-: " + neo);
    }
}
