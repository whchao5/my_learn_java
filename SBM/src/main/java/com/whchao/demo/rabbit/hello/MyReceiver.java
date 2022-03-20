package com.whchao.demo.rabbit.hello;



//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.Queue;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MyReceiver {
//
//    private static Logger log = LoggerFactory.getLogger(MyReceiver.class);
//    private final String queueName = "df";
//
//    static {
//
//    }
//
//
//    public void createQueue() {
//
//    }
//
////    @RabbitListener(queues = "my_queue")
//    @RabbitListener(queuesToDeclare = @Queue(queueName))
//    public void process(String hello) {
////        @RabbitListener(queuesToDeclare = @Queue(queueName))
//
////        System.out.println("Receiver : " + hello);
//        log.info("my_queue : " + hello);
//
//    }
//}
