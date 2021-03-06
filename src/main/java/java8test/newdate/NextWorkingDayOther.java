package java8test.newdate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

/**
 * @Author: wangmeng
 * @Date: 2018/9/27 上午11:36
 */
public class NextWorkingDayOther implements TemporalAdjuster {


    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        int dayToAdd = 1;
        if (dow == DayOfWeek.FRIDAY) {
            dayToAdd = 3;
        } else if (dow == DayOfWeek.SATURDAY) {
            dayToAdd = 2;
        }

        return temporal.plus(dayToAdd, ChronoUnit.DAYS);
    }


    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate with = now.with(new NextWorkingDayOther());
        System.out.println(with);

        LocalDate t2 = LocalDate.of(2019,7,15);
        for (int i = 0; i < 2; i++) {
            t2 =  t2.with(new NextWorkingDayOther());
        }
        System.out.println(t2);
    }
}
