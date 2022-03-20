package com.whchao.demo.rabbit;

//import org.springframework.amqp.core.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;

//
//@Configuration
//public class FanoutRabbitConfig {
//
//    private final static String aMessage  = "fanout.A";
//    private final static String bMessage = "fanout.B";
//    private final static String cMessage = "fanout.C";
//
//    @Bean
//    public Queue  AMessage() {
//        return new Queue(FanoutRabbitConfig.aMessage);
//    }
//
//    @Bean
//    public Queue BMessage() {
//        return new Queue("fanout.B");
//    }
//
//    @Bean
//    public Queue CMessage() {
//        return new Queue("fanout.C");
//    }
//
//
//    @Bean
//    FanoutExchange fanoutExchange() {
//        return new FanoutExchange("fanoutExchange");
//    }
//
//    @Bean
//    Binding bindingExchangeA(Queue AMessage, FanoutExchange fanoutExchange) {
//        return BindingBuilder.bind(AMessage).to(fanoutExchange);
//    }
//
//    @Bean
//    Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
//        return BindingBuilder.bind(BMessage).to(fanoutExchange);
//    }
//    @Bean
//    Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
//        return BindingBuilder.bind(CMessage).to(fanoutExchange);
//    }
//}
