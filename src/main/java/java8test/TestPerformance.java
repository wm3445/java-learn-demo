package java8test;

import java.util.function.Supplier;

/**
 * @Author: wangmeng
 * @Date: 2018/9/30 下午3:45
 */
public class TestPerformance {


    public static String execute(Supplier<Long> supplier) {
        String str = "";
        long last = Long.MAX_VALUE;
        for (int j = 0; j < 10; j++) {
            long start = System.nanoTime();
            supplier.get();
            long result = (System.nanoTime() - start) / 1_000_000;
            System.out.println("运行：" + result + "毫秒");
            last = result < last ? result : last;
        }
        System.out.println("testLongAdder最短时间：" + last + "毫秒");
        str = "testLongAdder最短时间：" + last + "毫秒";
        return str;
    }


}
