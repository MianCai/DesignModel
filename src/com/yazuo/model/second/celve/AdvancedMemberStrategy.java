package com.yazuo.model.second.celve;

/**
 * @Author: caimian
 * @Description:
 * @Date: 2018/5/11 14:14
 */
public class AdvancedMemberStrategy implements MemberStrategy {

    @Override
    public double calPrice(double bookPrice) {
        System.out.println("高级会员折扣为20%");
        return bookPrice*0.8;
    }
}
