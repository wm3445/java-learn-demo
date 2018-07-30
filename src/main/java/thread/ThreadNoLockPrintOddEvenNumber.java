package thread;

/**
 * @author wangmeng
 *
 * 利用 volatile 所有用于volatile修饰的变量的修改 happens-before 变量的读取
 */
public class ThreadNoLockPrintOddEvenNumber {


    private static int number = 1;

    private volatile static boolean flag = true;

    private static int max = 100;

    static class OddThread implements Runnable {

        @Override
        public void run() {
            while (number <= max) {
                if (flag) {
                    System.out.println(Thread.currentThread().getName() +"奇数线程打印 => " + number++);
                    flag = false;
                }
            }


        }
    }

    static class EvenThread implements Runnable {

        @Override
        public void run() {
            while (number <= max) {
                if (!flag) {
                    System.out.println(Thread.currentThread().getName() +"偶数线程打印 => " + number++);
                    flag = true;
                }
            }

        }
    }

    public static void main(String[] args) {
        OddThread oddThread = new OddThread();
        Thread thread1 = new Thread(oddThread);
        thread1.setName("Thread-1");
        thread1.start();
        EvenThread evenThread = new EvenThread();
        Thread thread2 = new Thread(evenThread);
        thread2.setName("Thread-2");
        thread2.start();

    }
}
