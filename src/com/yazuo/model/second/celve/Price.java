package com.yazuo.model.second.celve;

/**
 * @Author: caimian
 * @Description:
 * @Date: 2018/5/11 14:10
 */
public class Price {

    private MemberStrategy memberStrategy;

    public Price(MemberStrategy memberStrategy) {
        this.memberStrategy = memberStrategy;
    }

    /**
     * 计算图书价格
     */
    public double quote(double booksPrice){
        return  this.memberStrategy.calPrice(booksPrice);
    }
}
