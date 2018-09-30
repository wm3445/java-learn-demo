package java8test.newdate;

import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

/**
 * @Author: wangmeng
 * @Date: 2018/9/27 上午11:36
 */
public class NextWorkingDay implements TemporalAdjuster {

    private LocalDate localDate;

    public NextWorkingDay() {

    }

    public NextWorkingDay(LocalDate localDate) {
        this.localDate = localDate;
    }


    @Override
    public Temporal adjustInto(Temporal temporal) {
        LocalDate data = null == localDate ? LocalDate.now() : localDate;
        data = data.plusDays(1);
        while (data.getDayOfWeek().getValue() > 5) {
            data = data.plusDays(1);
        }
        return data;
    }

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate with = now.with(new NextWorkingDay(LocalDate.of(2018, 9, 27)));
        System.out.println(with);
    }
}
