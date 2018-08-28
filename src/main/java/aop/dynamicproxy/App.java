package aop.dynamicproxy;

import aop.staticproxy.MyInterface;
import aop.staticproxy.MyInterfaceImpl;

import java.lang.reflect.Proxy;

/**
 * @author wangmeng
 * <p>
 * 动态代理
 */
public class App {
    public static void main(String[] args) {

        CustomHandle customHandle = new CustomHandle(MyInterfaceImpl.class);
        MyInterface myInterface = (MyInterface) Proxy.newProxyInstance(App.class.getClassLoader(), new Class[]{MyInterface.class}, customHandle);
        myInterface.sayHello();
    }
}
