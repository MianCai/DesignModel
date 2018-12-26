package com.yazuo.celve;

/**
 * @Author: caimian
 * @Description:
 * @Date: 2018/5/11 14:16
 */
public class Client {
    public static void main(String[] args) {
        MemberStrategy strategy = new AdvancedMemberStrategy();

        Price price = new Price(strategy);
        Double quote = price.quote(300);
        System.out.println("图书价格为:"+quote);
    }
}
