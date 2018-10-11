package java8test;

import java.util.function.IntConsumer;

/**
 * @Author: wangmeng
 * @Date: 2018/10/11 下午5:13
 */
public class Main {

    public void print(int a, IntConsumer intConsumer) {
        intConsumer.accept(a);
    }

    public static void main(String[] args) {

        int b = 100;
        int finalB = b;
        IntConsumer intConsumer = (int a) -> {
            System.out.println(a);
            System.out.println(finalB);
        };
        b = 50;

        Main main = new Main();
        main.print(2, intConsumer);
        System.out.println(b);

    }
}
