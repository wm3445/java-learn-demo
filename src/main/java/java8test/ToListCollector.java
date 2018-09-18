package java8test;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @author wangmeng
 * 自定义实现一个tolist收集器
 */
public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {


    /**
     * 创建集合操作
     * @return
     */
    @Override
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    /**
     * 累积 遍历 过 的 项目， 原位 修改 累加器
     * @return
     */
    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return List::add;
    }

    /**
     * 将每个累加器组合在一起
     * @return
     */
    @Override
    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    /**
     * 恒等函数
     * @return
     */
    @Override
    public Function<List<T>, List<T>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(
                Characteristics.IDENTITY_FINISH,
                Characteristics.CONCURRENT
        ));

    }
}
