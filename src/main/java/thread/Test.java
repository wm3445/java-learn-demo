package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Author: king.wm
 * @Date: 2018/11/7 下午2:30
 * @Version 1.0
 */
public class Test {




    public synchronized void get(final long timeout, final TimeUnit unit)
            throws InterruptedException, ExecutionException, TimeoutException {
        long toMillis = unit.toMillis(timeout);
        System.out.println(toMillis);
        final long startTime = (toMillis <= 0) ? 0 : System.currentTimeMillis();
        long waitTime = toMillis;
        for (;;) {
            wait(waitTime);
            waitTime = toMillis - (System.currentTimeMillis() - startTime);
            if (waitTime <= 0) {
                throw new TimeoutException();
            }
            System.out.println("wait....");
        }

    }

    public synchronized void notifyGet(){

        this.notifyAll();
    }

    public static void main(String[] args) {

        Test test = new Test();
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test.notifyGet();
        }).start();
        try {
            test.get(10, TimeUnit.SECONDS);
        } catch (InterruptedException | TimeoutException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
