package java8test.newdate;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.time.temporal.TemporalAdjusters.*;

/**
 * @Author: wangmeng
 * @Date: 2018/9/27 上午11:31
 */
public class TemporalAdjusterDemo {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2018,9,27);
        System.out.println(date);
        LocalDate date1 = date.with(nextOrSame(DayOfWeek.FRIDAY));
        System.out.println(date1);
        LocalDate date2 = date1.with(lastDayOfMonth());
        System.out.println(date2);
    }
}
