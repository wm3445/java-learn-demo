package aop.dynamicproxy.cglib;

import aop.staticproxy.MyInterface;

/**
 * @Author: king.wm
 * @Date: 2019-03-01 15:13
 * @Version 1.0
 */
public class MyClassImpl implements MyInterface {

    @Override
    public void sayHello() {
        System.out.println("hello world!");
    }
}
