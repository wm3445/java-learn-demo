package java8test.newdate;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

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
        System.out.println("秒：" + time.getNano() / 1_000_000_000);

        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        String format = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(format);

    }

    public static void main(String[] args) {

        LocalTimeDemo dateDemo = new LocalTimeDemo();
        dateDemo.test();
        System.out.println("-=-=-=-=-=-=-=-=");

        String time = "16:45:05";
        String[] split = time.split(":");
        LocalTime of = LocalTime.of(Integer.valueOf(split[0]), Integer.valueOf(split[1]), Integer.valueOf(split[2]));
        System.out.println(of);

        LocalTime minus = of.minus(1, ChronoUnit.HOURS);
        System.out.println(minus);
    }


}
