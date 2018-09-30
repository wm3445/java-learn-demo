package base;

/**
 * @Author: wangmeng
 * @Date: 2018/9/30 下午2:39
 */
public class OuterClass {

    private OuterClass() {

        System.out.println("OuterClass init");
    }


    class InnerClass {

        InnerClass() {
            System.out.println("InnerClass init");
        }

        int size = 100;


    }

    static class InnerClass2 {

        static {
            System.out.println("InnerClass2 static ");
        }

        InnerClass2() {
            System.out.println("InnerClass2 init ");
        }

        int size = 200;
    }

    public void test() {
        // 外部类的方法中都可以直接new内部类
        InnerClass innerClass = new InnerClass();

        InnerClass2 innerClass22 = new InnerClass2();

        System.out.println("-=-=-=-=-=-=-");

    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        // 非静态内部类需要外部类对象new
        InnerClass innerClass = outerClass.new InnerClass();
        outerClass.test();
        // 可以直接new静态内部类
        InnerClass2 innerClass22 = new InnerClass2();
    }
}

