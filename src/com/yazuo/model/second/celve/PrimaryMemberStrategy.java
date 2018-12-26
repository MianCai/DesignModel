package com.yazuo.model.second.celve;

/**
 * @Author: caimian
 * @Description:
 * @Date: 2018/5/11 14:14
 */
public class PrimaryMemberStrategy implements MemberStrategy {

    @Override
    public double calPrice(double bookPrice) {
        System.out.println("初级会员没有折扣");
        return bookPrice;
    }
}
