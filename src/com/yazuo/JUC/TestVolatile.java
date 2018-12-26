package com.yazuo.JUC;

/**
 * @Author: caimian
 * @Description:
 * @Date: 2018/7/13 16:51
 */
public class TestVolatile {

    public static void main(String[] args) {

        Threaddemo d = new Threaddemo();
        new Thread(d).start();
        while(true){
          if(d.isIsflag()){
              System.out.println("#########");
              break;
          }
        }
    }
}

class Threaddemo implements Runnable{
    private volatile boolean isflag =false;
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isflag=true;
        System.out.println("flag ="+isflag);
    }

    public boolean isIsflag() {
        return isflag;
    }

    public void setIsflag(boolean isflag) {
        this.isflag = isflag;
    }
}
