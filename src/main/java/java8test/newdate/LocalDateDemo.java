package java8test.newdate;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;

/**
 * @Author: wangmeng
 * @Date: 2018/9/27 上午10:43
 * java8新增的日期api
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
    }

    public static void main(String[] args) {
        LocalDateDemo dateDemo = new LocalDateDemo();
        dateDemo.test();
        System.out.println("-=-=-=-=-=-=-=-=-");
        dateDemo.test2();
    }
}
