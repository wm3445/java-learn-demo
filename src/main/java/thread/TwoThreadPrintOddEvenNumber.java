package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangmeng
 * <p>
 * 两个线程交替打印奇偶数
 */
public class TwoThreadPrintOddEvenNumber {

    private volatile static int number = 1;

    private final static int max = 100;

    private final static Lock LOCK = new ReentrantLock();

    public static boolean flag = true;

    TwoThreadPrintOddEvenNumber() {

    }


    static class OddThread implements Runnable {

        @Override
        public void run() {
            while (number <= max) {
                if (flag) {
                    try {
                        LOCK.lock();
                        System.out.println("奇数线程打印 => " + number++);
                        flag = false;
                    } finally {
                        LOCK.unlock();
                    }

                } else {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    static class EvenThread implements Runnable {

        @Override
        public void run() {
            while (number <= max) {

                if (!flag) {
                    try {
                        LOCK.lock();
                        System.out.println("偶数线程打印 => " + number++);
                        flag = true;
                    } finally {
                        LOCK.unlock();
                    }
                } else {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }

        }
    }


    public static void main(String[] args) {
        OddThread oddThread = new OddThread();
        new Thread(oddThread).start();

        EvenThread evenThread = new EvenThread();
        new Thread(evenThread).start();
    }
}
