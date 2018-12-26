package com.yazuo.JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: caimian
 * @Description:
 * @Date: 2018/7/17 17:41
 */
public class TestLock {
    public static void main(String[] args) {
        LockDemo td = new LockDemo();
        new Thread(td,"窗口1").start();
        new Thread(td,"窗口2").start();
        new Thread(td,"窗口3").start();
    }
}
class LockDemo implements Runnable{

    private Lock lock = new ReentrantLock();
    private Condition condition= lock.newCondition();
    int  tick = 100;
    @Override
    public void run() {
    while (true) {
        lock.lock();

        try {
            if (tick > 0) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "恭喜你购买成功,余票为:" + --tick);
            }
        }finally {
            lock.unlock();
        }
    }

    }
}