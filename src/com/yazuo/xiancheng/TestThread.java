package com.yazuo.xiancheng;

/**
 * @Author: caimian
 * @Description:
 * @Date: 2018/6/4 16:19
 */
public class TestThread {
    public static void main(String[] args) {
        Thread t = new Prossor();

        t.start();
        for (int i=0;i<100;i++){
            System.out.println("主线程"+i);
        }

    }
}

//定义一个线程
class Prossor extends Thread{

    @Override
    public void run(){
        for (int i=0;i<100;i++){
            System.out.println("线程一"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
