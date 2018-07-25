package aop.staticproxy;


/**
 * @author wangmeng
 */
public class MyInterfaceImpl implements MyInterface {
    @Override
    public void sayHello() {
        System.out.println("hello world!");
    }
}
