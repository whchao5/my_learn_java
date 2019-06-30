package com.whchao.demo.rabbit.fanout;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.B")
public class FanoutReceiverB {

    private static Logger log = LoggerFactory.getLogger(FanoutReceiverB.class);

    @RabbitHandler
    public void process(String message) {

//        System.out.println("Receiver : " + hello);
        log.info("fanout Receiver B  : " + message);

    }
}
