package com.whchao.demo.rabbit.fanout;


import com.whchao.demo.rabbit.hello.HelloReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.A")
public class FanoutReceiverA {

    private static Logger log = LoggerFactory.getLogger(FanoutReceiverA.class);

    @RabbitHandler
    public void process(String message) {

//        System.out.println("Receiver : " + hello);
        log.info("fanout Receiver A  : " + message);

    }
}
