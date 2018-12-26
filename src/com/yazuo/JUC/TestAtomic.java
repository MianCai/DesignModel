package com.yazuo.JUC;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: caimian
 * @Description:
 * @Date: 2018/7/16 16:54
 */
public class TestAtomic {
    public static void main(String[] args) {
        AtomicDemo demo = new AtomicDemo();

        for(int i =0;i<10;i++){
            new Thread(demo).start();
        }

    }
}

class  AtomicDemo implements  Runnable{

    private AtomicInteger num = new AtomicInteger();
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getAtomicNum());
    }

    public  int getAtomicNum(){
        return num.getAndIncrement();
    }


}
