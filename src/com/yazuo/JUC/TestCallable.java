package com.yazuo.JUC;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 相较于Runnable接口的方式，方法可以有返回值，并且可以抛出异常

 */
public class TestCallable {

    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
       //执行Callable方式，需要FutureTask实现类的支持，用于接收运算结果
        Future<Integer> result = new FutureTask<>(td);

        new Thread((Runnable) result).start();
        try {
            Integer sum = result.get();// 有闭锁的功能.线程不结束，不执行下面代码
            System.out.println(sum);
            System.out.println("------------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
class ThreadDemo implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <Integer.MAX_VALUE ; i++) {
            sum+=i;
        }
        return  sum;
    }
}
