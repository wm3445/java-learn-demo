package thread;

/**
 * @author wangmeng
 * <p>
 * 简单实现一个死锁程序
 */
public class DealLock {

    public static String lock1 = "lock1";


    public static String lock2 = "lock2";


    static class Lock1 implements Runnable {


        @Override
        public void run() {
            synchronized (DealLock.lock1) {
                System.out.println("lock1 获取到锁");
                System.out.println("尝试获取锁 lock2");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (DealLock.lock2) {
                    System.out.println("lock2 获取到锁 --- ");
                }
            }
        }
    }


    static class Lock2 implements Runnable {

        @Override
        public void run() {
            synchronized (DealLock.lock2) {
                System.out.println("lock2 获取到锁");
                System.out.println("尝试获取锁 lock1");
                synchronized (DealLock.lock1) {
                    System.out.println("lock1 获取到锁 ====");
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Lock1());
        Thread thread2 = new Thread(new Lock2());

        thread1.start();
        thread2.start();

    }
}
