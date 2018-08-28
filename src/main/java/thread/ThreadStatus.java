package thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @author wangmeng
 */
public class ThreadStatus {


    public static void main(String[] args) {
        // 线程状态为 初始NEW
        Thread thread = new Thread();
        // 进入 运行状态RUNNABLE线程池中 READY状态 -> 等待系统调度 -> 运行中RUNNING
        thread.start();
        //
        try {
            // 让线程进入waiting状态 3种方法
            thread.wait();
            thread.join();
            LockSupport.park();
            // 唤醒重新进入 READY状态
            thread.notify();
            thread.notifyAll();
            LockSupport.unpark(thread);
            // 线程进入阻塞状态
            synchronized (ThreadStatus.class) {

            }

            // 进入超时等待
            Thread.sleep(100);
            thread.wait(100);
            thread.join(100);
            LockSupport.parkNanos(100);
            LockSupport.parkUntil(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
