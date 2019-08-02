package aop.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: king.wm
 * @Date: 2019-03-01 15:15
 * @Version 1.0
 */
public class CustomHandelCglib<T> implements MethodInterceptor {

    public T getInstance(Class<?> target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target);
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return (T)enhancer.create();
    }

    @Override
    public T intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        methodProxy.invokeSuper(o, objects);
        after();
        return null;
    }

    public void before() {
        System.out.println("sayHello before execute！");

    }

    public void after() {
        System.out.println("sayHello after execute！");
    }
}
