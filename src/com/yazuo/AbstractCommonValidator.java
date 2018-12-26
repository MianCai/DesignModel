package com.yazuo;

/**
 * @Author: caimian
 * @Description:
 * @Date: 2018/7/11 13:31
 */
public class AbstractCommonValidator implements Validator<People>{
    @Override
    public void validate(People people) {
        System.out.println("xxxxxxxxxxxx");
    }
}
