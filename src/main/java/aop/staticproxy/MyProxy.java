package aop.staticproxy;

/**
 * @author wangmeng
 */
public class MyProxy implements MyInterface {

    MyInterface myInterface;

    public MyProxy() {
        myInterface = new MyInterfaceImpl();
    }


    @Override
    public void sayHello() {
        before();
        myInterface.sayHello();
        after();
    }


    public void before(){
        System.out.println("sayHello before execute！");

    }

    public void after(){
        System.out.println("sayHello after execute！");
    }
}
