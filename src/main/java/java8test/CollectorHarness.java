package java8test;

import java.util.function.Consumer;

/**
 * @author wangmeng
 * <p>
 * 基于 partitioningBy 分区方法和 自定义分区方法的性能测试
 * <p>
 * partioningBy 结果如下
 * done in 1229
 * done in 651
 * done in 655
 * done in 620
 * done in 738
 * done in 572
 * done in 579
 * done in 566
 * done in 722
 * done in 724
 * Partitioning done in: 566 msecs
 * <p>
 * 自定义分区收集器性能如下
 * done in 805
 * done in 669
 * done in 469
 * done in 358
 * done in 322
 * done in 459
 * done in 348
 * done in 323
 * done in 325
 * done in 325
 * Partitioning done in: 322 msecs
 */
public class CollectorHarness {


    public static void main(String[] args) {
        //System.out.println("Partitioning done in: " + execute(PrimeNumbersCollector::partitionPrimes) + " msecs");
        System.out.println("Partitioning done in: " + execute(PrimeNumbersCollector::partitionPrimesWithCustomCollector) + " msecs");
    }

    private static long execute(Consumer<Integer> primePartitioner) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            primePartitioner.accept(1_000_000);
            long duration = (System.nanoTime() - start) / 1_000_000;
            if (duration < fastest) {
                fastest = duration;
            }
            System.out.println("done in " + duration);
        }
        return fastest;
    }
}
