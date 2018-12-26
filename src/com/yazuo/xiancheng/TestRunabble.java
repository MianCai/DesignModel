package com.yazuo.xiancheng;

/**
 * @Author: caimian
 * @Description:
 * @Date: 2018/6/4 16:27
 */
public class TestRunabble {
    public static void main(String[] args) {
Thread t = new Thread(new Prossore());
        t.start();
    }
}

class Prossore implements  Runnable{

    @Override
    public void run() {
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
