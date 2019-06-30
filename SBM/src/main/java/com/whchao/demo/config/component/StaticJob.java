package com.whchao.demo.config.component;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class StaticJob {

    private static Logger logger = LoggerFactory.getLogger(StaticJob.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private final static long SECOND = 1000;

    /**
     * fixedDelay: 固定延迟时间执行
     */
    @Scheduled(fixedRate = 10 * SECOND)
    public void fixedDelayJob() {
        logger.info("现在时间：" + dateFormat.format(new Date()));
    }

}
