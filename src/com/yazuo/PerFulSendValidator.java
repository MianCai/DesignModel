package com.yazuo;

/**
 * @Author: caimian
 * @Description:
 * @Date: 2018/7/11 13:30
 */
public class PerFulSendValidator extends  AbstractCommonValidator {
    @Override
    public void validate(People people) {
        super.validate(people);
        System.out.println(people.getName());
    }
}
