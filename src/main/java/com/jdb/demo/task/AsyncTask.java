package com.jdb.demo.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

@Component
@Async
public class AsyncTask {

    //@Async
    public Future task1(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("--------------异步任务task1-------------"+new Date());
        return new AsyncResult<String>("异步任务task1");
//        return new FutureTask(new Callable() {
//            @Override
//            public String call() throws Exception {
//                return "执行完成task1";
//            }
//        });
    }

    //@Async
    public Future task2(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("--------------异步任务task2-----------"+new Date());
        return new AsyncResult<String>("异步任务task2");
//        return new FutureTask(new Callable() {
//            @Override
//            public String call() throws Exception {
//                return "执行完成task2";
//            }
//        });

    }
}
