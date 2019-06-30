package com.whchao.demo.rabbit.object;


import com.whchao.demo.entity.Area;
import com.whchao.demo.rabbit.hello.HelloReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RabbitListener(queues = "object")
public class ObjectReceiver {


    private static Logger log = LoggerFactory.getLogger(ObjectReceiver.class);
    @RabbitHandler
    public void process(List areaList) {
//        System.out.println("Receiver object : " + areaList);
        log.info("Receiver object : " + areaList);
    }

}
