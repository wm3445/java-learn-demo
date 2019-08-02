package aop.dynamicproxy;

import aop.dynamicproxy.cglib.CustomHandelCglib;
import aop.dynamicproxy.cglib.MyClassImpl;
import aop.staticproxy.MyInterface;
import aop.staticproxy.MyInterfaceImpl;

import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * @author wangmeng
 * <p>
 * 动态代理
 */
public class App {
    public static void main(String[] args) throws IOException {

        CustomHandle customHandle = new CustomHandle(MyInterfaceImpl.class);
        MyInterface myInterface = (MyInterface) Proxy.newProxyInstance(App.class.getClassLoader(), new Class[]{MyInterface.class}, customHandle);
        myInterface.sayHello();

        // cglib
        System.out.println("-=-=-=-=-=-= cglib -=-=-=-=-=-=-=-");
        CustomHandelCglib<MyClassImpl> customHandelCglib = new CustomHandelCglib<>();
        MyClassImpl myClass = customHandelCglib.getInstance(MyClassImpl.class);
        myClass.sayHello();

    }
}
