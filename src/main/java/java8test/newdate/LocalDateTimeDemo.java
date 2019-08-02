package java8test.newdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

/**
 * @Author: wangmeng
 * @Date: 2018/9/27 上午10:43
 * java8新增的日期api
 */
public class LocalDateTimeDemo {


    public void test() {
        LocalDateTime now = LocalDateTime.now();
        long l = LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 59, 59)).toEpochSecond(ZoneOffset.of("+8"));
        long l1 = now.toEpochSecond(ZoneOffset.of("+8"));
        long a =  l - l1;
        System.out.println(a);


    }

    public static void main(String[] args) {
        LocalDateTimeDemo dateDemo = new LocalDateTimeDemo();
        dateDemo.test();
    }
}
