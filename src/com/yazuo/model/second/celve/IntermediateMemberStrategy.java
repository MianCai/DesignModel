package com.yazuo.model.second.celve;

/**
 * @Author: caimian
 * @Description:
 * @Date: 2018/5/11 14:14
 */
public class IntermediateMemberStrategy implements MemberStrategy {

    @Override
    public double calPrice(double bookPrice) {
        System.out.println("中级会员折扣为10%");
        return bookPrice*0.9;
    }
}
