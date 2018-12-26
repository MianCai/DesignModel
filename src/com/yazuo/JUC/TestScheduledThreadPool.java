package com.yazuo.JUC;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @Author: caimian
 * @Description:
 * @Date: 2018/7/18 15:12
 */
public class TestScheduledThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService pool =  Executors.newScheduledThreadPool(5);
        for (int i = 0; i <5 ; i++) {
            Future<Integer> future =  pool.schedule(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int num = new Random().nextInt(100);
                    System.out.println(Thread.currentThread().getName()+":"+num);
                    return num;
                }
            },1, TimeUnit.SECONDS);
            System.out.println(future.get());
        }
        pool.shutdown();
    }
}
