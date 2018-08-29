package thread;

/**
 * @author wangmeng
 */
public class SynchronizedDemo {


    static int num = 0;

    static int count = 0;


    final static String lock = "lock";


    synchronized void run1() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(num++);
    }

    void run2() {
        synchronized (SynchronizedDemo.class) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(num++);
        }
    }

    void run3() {
        synchronized (lock) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(num++);
        }
    }

    static synchronized void run4() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(num++);
    }

    void run5() {
        synchronized (this) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(num++);
        }
    }

    void run6(){
        synchronized (SynchronizedDemo.class) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(num++ +" num");
            synchronized (this){
                System.out.println(count++ + " count");
            }
        }
    }

    static void test1() {

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
                synchronizedDemo.run1();
            }).start();
        }
    }

    static void test2() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
                synchronizedDemo.run2();
            }).start();
        }
    }

    static void test3() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
                synchronizedDemo.run3();
            }).start();
        }
    }

    static void test4() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                SynchronizedDemo.run4();
            }).start();
        }
    }

    static void test5() {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                synchronizedDemo.run5();
            }).start();
        }
    }

    static void test6() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
                synchronizedDemo.run6();
            }).start();
        }
    }

    public static void main(String[] args) {
        // 锁不住
        // test1();

        // 可以锁住
        // test2();

        // 可以锁住
        //test3();

        // 可以锁住
        //test4();

        //锁住
       // test5();

        test6();
    }
}
