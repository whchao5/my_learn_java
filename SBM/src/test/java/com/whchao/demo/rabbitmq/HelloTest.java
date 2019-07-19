package com.whchao.demo.rabbitmq;

import com.whchao.demo.rabbit.hello.HelloSender;
import com.whchao.demo.rabbit.hello.MySender;
//import com.whchao.demo.rabbit.object.ObjectSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloTest {

    @Autowired
    private HelloSender helloSender;

//    @Autowired
//    private ObjectSender objectSender;

    @Autowired
    private MySender mySender;

    @Test
    public void hello() throws Exception {

        for (int i = 0; i < 50; i++) {
//            Thread.sleep(100);
            helloSender.send();
        }
    }


//    @Test
//    public void object() throws Exception {

//        for (int i = 0; i < 50; i++) {
//            Thread.sleep(100);
//            objectSender.send();
//        }
//    }



    @Test
    public void MyQueue() throws Exception {

        for (int i = 0; i < 500; i++) {
//            Thread.sleep(100);
            mySender.send();
        }
    }
}
