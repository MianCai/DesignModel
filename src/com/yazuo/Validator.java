package com.yazuo;

/**
 * @Author: caimian
 * @Description:
 * @Date: 2018/7/11 13:28
 */
public interface Validator<T> {

    void validate(T t);
}
