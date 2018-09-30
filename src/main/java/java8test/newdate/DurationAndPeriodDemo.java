package java8test.newdate;

import java.time.Duration;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * @Author: wangmeng
 * @Date: 2018/9/27 上午11:11
 */
public class DurationAndPeriodDemo {

    public static void main(String[] args) {
        Duration threeMinutes = Duration.ofMinutes(3);
        Duration threeMinutes2 = Duration.of(3, ChronoUnit.MINUTES);
        Period tenDays = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);

    }

}
