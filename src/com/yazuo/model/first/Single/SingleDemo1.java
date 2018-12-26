package com.yazuo.model.first.Single;

/**
 * @Author: caimian
 * @Description:单例模式之饿汉
 * @Date: 2018/12/26 15:11
 */
public class SingleDemo1 {

    /**
     * 饿汉 类初始化立即加载。因为只初始化一次，不会有线程安全
     */
    private static  final SingleDemo1 singleDemo1 = new SingleDemo1();

    private SingleDemo1() {
    }
    public static  SingleDemo1 getInstance(){
        return singleDemo1;
    }

    public  static  void main(String[] args){
        SingleDemo1 s1=  SingleDemo1.getInstance();
        System.out.println(s1);
    }
}
