package java8test.newdate;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: wangmeng
 * @Date: 2018/9/27 上午10:43 java8新增的日期api
 */
public class LocalDateDemo {

    public void test() {
        LocalDate now = LocalDate.now();
        System.out.println("当前日期:" + now);
        System.out.println("年:" + now.getYear());
        System.out.println("月:" + now.getMonthValue());
        System.out.println("日:" + now.getDayOfMonth());
        System.out.println("当月天数:" + now.lengthOfMonth());
        System.out.println("是否为闰年:" + now.isLeapYear());
        System.out.println("添加一周:" + now.plusWeeks(1));
        System.out.println("减一年:" + now.minusYears(1));
        System.out.println("添加6个月:" + now.plus(6, ChronoUnit.MONTHS));
        System.out.println(now.with(ChronoField.MONTH_OF_YEAR, 8));

    }

    public void test2() {
        LocalDate date = LocalDate.of(2014, 3, 18);
        System.out.println(date);
        date = date.with(ChronoField.MONTH_OF_YEAR, 9);
        System.out.println(date);
        date = date.plusYears(2).minusDays(10);
        System.out.println(date);
        LocalDate localDate = date.withYear(2011);
        System.out.println(date + "   " + localDate);
        LocalDate now = LocalDate.now();
        String yyyyMMdd = LocalDate.of(now.getYear(), now.getMonth(), 8)
            .format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        System.out.println(yyyyMMdd);
    }

    /**
     * 时区
     */
    public void test3() {

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        LocalDateTime localDateTime = now.minusHours(1);

    }

    public void test4(){


        LocalDateTime startDate = LocalDateTime.parse("2019-05-01T00:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        LocalDateTime endDate = LocalDateTime.parse("2019-05-01T23:59:59", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        for (LocalDateTime d = startDate; !d.isAfter(endDate); d = d.plus(30, ChronoUnit.MINUTES)) {
            System.out.println(d);
        }

    }

    public static void main(String[] args) {
        LocalDateDemo dateDemo = new LocalDateDemo();
        dateDemo.test();
        System.out.println("-=-=-=-=-=-=-=-=-");
        dateDemo.test2();
        System.out.println("-=-=-=-=-=-=-=-=-");
        dateDemo.test3();
        System.out.println("-=-=-=-=-=-=-=-=-");
        dateDemo.test4();
        System.out.println("-=-=-=-=-=-=-=-=-");


        LocalDateTime startDateTime = LocalDateTime.now();
        LocalDateTime endDateTime = LocalDateTime.now();
        for (LocalDateTime d = startDateTime; !d.isAfter(endDateTime); d = d.plusDays(1)) {
            System.out.println(d.toLocalDate());
        }

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime plus = localDateTime.plus(1, ChronoUnit.DAYS);
        System.out.println(plus.toLocalDate());

    }


}
