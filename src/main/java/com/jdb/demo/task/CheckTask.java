package com.jdb.demo.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
@EnableScheduling
public class CheckTask {

    @Scheduled(fixedRate = 2000 )
    public void check1() throws Exception{
        //System.err.println("--------------定时任务-fixedRate-------------"+new Date());
        Thread.sleep(3000);
    }

    @Scheduled(fixedDelay = 2000 )
    public void check2() throws Exception{
        //System.err.println("--------------定时任务-fixedDelay-----------"+new Date());
        Properties p = new Properties();
        //p.load();
        Thread.sleep(3000);
    }

}
