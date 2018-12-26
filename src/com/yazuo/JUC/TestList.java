package com.yazuo.JUC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: caimian
 * @Description:
 * @Date: 2018/7/16 18:26
 */
public class TestList {
    public static void main(String[] args) {
        HellwThread td= new HellwThread();
        for (int i = 0; i < 10; i++) {
            new Thread(td).start();
        }
    }
}
class HellwThread implements  Runnable{
    //  private static List<String> list = new ArrayList<>();
   private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
    static {
        list.add("AA");
        list.add("BB");
        list.add("CC");
    }
    @Override
    public void run() {
        Iterator<String> it =list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
            list.add("AA");
        } }}
