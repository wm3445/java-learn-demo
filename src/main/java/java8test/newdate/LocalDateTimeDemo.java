package java8test.newdate;

import java.time.LocalDateTime;

/**
 * @Author: wangmeng
 * @Date: 2018/9/27 上午10:43
 * java8新增的日期api
 */
public class LocalDateTimeDemo {


    public void test() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

    }

    public static void main(String[] args) {
        LocalDateTimeDemo dateDemo = new LocalDateTimeDemo();
        dateDemo.test();
    }
}
