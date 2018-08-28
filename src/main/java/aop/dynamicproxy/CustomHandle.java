package aop.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wangmeng
 * <p>
 * 自定义处理逻辑
 */
public class CustomHandle implements InvocationHandler {

    /**
     * 动态代理对象
     */
    private Object target;

    public CustomHandle(Class clazz) {
        try {
            target = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(target, args);
        after();
        System.out.println("proxy class -> " + proxy.getClass());
        return invoke;
    }

    public void before() {
        System.out.println("sayHello before execute！");

    }

    public void after() {
        System.out.println("sayHello after execute！");
    }
}
