package com.yazuo.JUC;

import java.util.concurrent.*;

/**
 * @Author: caimian
 * @Description:
 * @Date: 2018/7/17 13:22
 */
public class TestCountDownLatch {
    public static void main(String[] args) {
        //初始线程为5
        CountDownDemo demo = new CountDownDemo();
        FutureTask<Integer> result =new FutureTask<>(demo);
        long start = System.currentTimeMillis();
        for (int i = 0; i <5 ; i++) {
            new Thread(result).start();
            try {
               Integer sum =  result.get();
                System.out.println(i+"========"+sum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        //latch没有减到0，主线程一直等待

        long end = System.currentTimeMillis();
        System.out.println("耗时为:"+(end-start));
    }
}
class CountDownDemo implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <5000 ; i++) {
            sum+=i;
        }
        return sum;
    }
}
