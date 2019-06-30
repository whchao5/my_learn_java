package com.whchao.demo.rabbit.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NeoSender {

    private static Logger log = LoggerFactory.getLogger(NeoSender.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(int i) {
        String context = "spirng boot neo queue" + " ****** " + i;

//        System.out.println("Sender 1 - " + i + ": " + context);
        log.info("Sender 1 - " + i + ": " + context);

        this.rabbitTemplate.convertAndSend("neo", context);
    }
}
