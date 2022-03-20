package com.whchao.demo.rabbit.object;

//import com.whchao.demo.entity.Area;
//import com.whchao.demo.rabbit.topic.TopicSender;
//import com.whchao.demo.service.AreaService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;

//@Component
//public class ObjectSender {
//
//    private static Logger log = LoggerFactory.getLogger(ObjectSender.class);
//
//    @Autowired
//    private AmqpTemplate rabbitTemplate;
//
//
//    @Autowired
//    private AreaService areaService;
//
//
//    public void send() {
//
//        List<Area> areaList = areaService.getAreaList();
//
//        log.info("areaList ：" + areaList.toString());
//        this.rabbitTemplate.convertAndSend("object", areaList);
//    }
//}
