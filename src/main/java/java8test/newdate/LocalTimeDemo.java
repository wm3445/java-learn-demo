package java8test.newdate;

import java.time.LocalTime;

/**
 * @Author: wangmeng
 * @Date: 2018/9/27 上午10:43
 * java8新增的日期api
 */
public class LocalTimeDemo {


    public void test() {
        LocalTime time = LocalTime.now();
        System.out.println(time);
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());
        System.out.println("纳秒：" + time.getNano());
        System.out.println("毫秒：" + time.getNano() / 1_000_000);


    }

    public static void main(String[] args) {
        LocalTimeDemo dateDemo = new LocalTimeDemo();
        dateDemo.test();
    }
}
