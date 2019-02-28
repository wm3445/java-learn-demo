package java8test.atomic;

import java8test.TestPerformance;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Author: wangmeng
 * @Date: 2018/9/30 下午3:29
 */
public class AtomicPerformanceTest {

    public static void main(String[] args) {
        TestPerformance.execute(AtomicPerformanceTest::testAtomicLong);
        //testAtomicLong();
        System.out.println("-=-=-=-=-=-=-=--=-=");
        // testLongAdder();
        TestPerformance.execute(AtomicPerformanceTest::testLongAdder);

    }

    public static long testAtomicLong() {


        AtomicLong atomicLong = new AtomicLong();
        for (long i = 0; i < 1_000_000_000L; i++) {
            atomicLong.incrementAndGet();
        }
        return atomicLong.get();
    }


    public static long testLongAdder() {
        LongAdder longAdder = new LongAdder();
        for (long i = 0; i < 1_000_000_000L; i++) {
            longAdder.increment();
        }
        return longAdder.longValue();
    }
}
