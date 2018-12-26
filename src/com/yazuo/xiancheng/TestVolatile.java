package com.yazuo.xiancheng;

/**
 * @Author: caimian
 * @Description:
 * @Date: 2018/7/5 13:38
 */
public class TestVolatile {

    public static void main(String[] args) {
        Threaddemo td = new  Threaddemo();
       new Thread(td).start();

       while (true){
           if(td.isIsflag()){
               System.out.println("#########");
               break;
           }
       }
    }
}

class  Threaddemo implements Runnable{

    private   boolean isflag =false;
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isflag = true;
        System.out.println("flag ="+isflag);

    }

    public boolean isIsflag() {
        return isflag;
    }

    public void setIsflag(boolean isflag) {
        this.isflag = isflag;
    }
}
