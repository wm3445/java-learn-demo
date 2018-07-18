package thread;

/**
 * @author wangmeng
 *
 * 利用线程间通讯来打印奇偶数
 */
public class ThreadNotifyPrintOddEvenNumber {


    private static int number = 1;

    private static boolean flag = true;

    private static int max = 100;

    static class OddThread implements Runnable {

        @Override
        public void run() {
            synchronized (ThreadNotifyPrintOddEvenNumber.class){
                while (number <= max) {
                    if (flag) {
                        System.out.println(Thread.currentThread().getName() +"奇数线程打印 => " + number++);
                        flag = false;
                        ThreadNotifyPrintOddEvenNumber.class.notify();
                    } else {
                        try {
                            ThreadNotifyPrintOddEvenNumber.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }


        }
    }

    static class EvenThread implements Runnable {

        @Override
        public void run() {
            synchronized (ThreadNotifyPrintOddEvenNumber.class){
                while (number <= max) {
                    if (!flag) {
                        System.out.println(Thread.currentThread().getName() +"偶数线程打印 => " + number++);
                        flag = true;
                        ThreadNotifyPrintOddEvenNumber.class.notify();
                    } else {
                        try {
                            ThreadNotifyPrintOddEvenNumber.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
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
