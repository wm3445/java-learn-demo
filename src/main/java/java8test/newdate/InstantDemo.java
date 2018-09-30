package java8test.newdate;

import java.time.Instant;

/**
 * @Author: wangmeng
 * @Date: 2018/9/27 上午11:04
 */
public class InstantDemo {


    public void test() {
        System.out.println(Instant.ofEpochSecond(3));
        System.out.println(Instant.ofEpochSecond(3, 0));
        System.out.println(Instant.ofEpochSecond(2, 1_000_000_000));
        System.out.println(Instant.ofEpochSecond(4, -1_000_000_000));

        System.out.println("当前时间戳:" + Instant.now());

        System.out.println(Instant.MIN);

    }

    public static void main(String[] args) {
        InstantDemo demo = new InstantDemo();
        demo.test();
    }
}
