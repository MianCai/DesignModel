package com.yazuo.JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
编写一个程序，开启3个线程，这三个线程的Id分别为A、B、C，每个线程将自己的Id在屏幕上打印5遍
 要求输出的结果必须按顺序显示，5A10B20C
 */
public class TestABCAlternate {
    public static void main(String[] args) {
        AlternateDemo td = new AlternateDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <=5 ; i++) {
                    td.loopA(i);
                }

            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <=5 ; i++) {
                    td.loopB(i);
                }
            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <=5 ; i++) {
                    td.loopC(i);
                    System.out.println("--------------------------------------------");
                }
            }
        },"C").start();
    }
}

class AlternateDemo{
    private int num =1;//标记当前正在执行的线程

    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    public void loopA(int t)  {
        lock.lock();
        try{
            //1、判断。不是1不能打印
            if(num!=1){
                c1.await();
            }
            //否则
            for (int i = 1; i <=5 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i+"第几轮\t"+t);
            }
            // 唤醒2执行
            num=2;
            c2.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void loopB(int t)  {
        lock.lock();
        try{
            //1、判断。不是1不能打印
            if(num!=2){
                try {
                    c2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //否则
            for (int i = 1; i <=15 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+t);
            }
            // 唤醒2执行
            num=3;
            c3.signal();

        }finally {
            lock.unlock();
        }

    }

    public void loopC(int t)  {
        lock.lock();
        try{
            //1、判断。不是1不能打印
            if(num!=3){
                c3.await();
            }
            //否则
            for (int i = 1; i <=20 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+t);
            }
            // 唤醒2执行
            num=1;
            c1.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}
