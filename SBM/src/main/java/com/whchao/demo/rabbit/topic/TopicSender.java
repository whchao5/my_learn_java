package com.whchao.demo.rabbit.topic;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {

    private static Logger log = LoggerFactory.getLogger(TopicSender.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;


    public void send() {
        String context = "hi, i am message all";
        log.info("Sender ：" + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.1", context);
    }

    public void send1() {
        String context = "hi, i am message 1";
        log.info("Sender 1 ：" + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.message", context);
    }


    public void send2() {
        String context = "hi, i am message 2";
        log.info("Sender 2 ：" + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.messages", context);
    }


}
