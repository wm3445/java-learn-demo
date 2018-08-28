package aop.staticproxy;

/**
 * @author wangmeng
 * <p>
 * 静态代理
 */
public class App {


    public static void main(String[] args) {
        MyInterface myInterface = new MyProxy();
        myInterface.sayHello();
    }
}
