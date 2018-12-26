package com.yazuo.JUC;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: caimian
 * @Description:
 * @Date: 2018/7/18 00:16
 */
public class TestExecutors {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建线程池
        ExecutorService executor=Executors.newFixedThreadPool(10);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            Future<Integer> f = executor.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                    for(int i=0;i<=100;i++){
                        sum +=i;
                    }
                    list.add(sum);
                    return sum;
                }
            }) ;
        }

        executor.shutdown();
        System.out.println(list);


//        ThreadDemo2 td = new ThreadDemo2();
//        for (int i = 0; i <10 ; i++) {
//            // 为线程池分配任务
//            executor.submit(td);
//        }
//        // 关闭线程池
//        executor.shutdown();
    }
}
class ThreadDemo2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            System.out.println(Thread.currentThread().getName()+":"+ i);
        }
    }
}
