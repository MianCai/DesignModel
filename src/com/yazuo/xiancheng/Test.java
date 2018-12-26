package com.yazuo.xiancheng;

import org.omg.CORBA.SystemException;

import java.util.concurrent.*;

/**
 * @Author: caimian
 * @Description:
 * @Date: 2018/6/6 10:27
 */
public class Test {
    public static void main(String[] args) {
        // corePoolSize核心池的大小
        // maximumPoolSize线程池最大线程数
        //keepAliveTime表示线程没有任务执行时最多保持多久时间会终止。
        // unit参数keepAliveTime的时间单位

        ThreadPoolExecutor executor = new ThreadPoolExecutor(20, 30, 200, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(30), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(true);//使用守护线程的方式不会阻止程序的停止
                t.setName("停止:" + t.getName());
                return t;
            }
        }, new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
               // log.info(">>>执行过的最大线程数>>>"+executor.getLargestPoolSize());
               // throw new SystemException(CodeConstant.FATAL_UNKNOWN,"线程池饱和了,请调整线程池大小");
            }
        });

        for(int i=0;i<15;i++){
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}

class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }

    @Override
    public void run() {
        System.out.println("正在执行task "+taskNum);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task "+taskNum+"执行完毕");
    }
}
