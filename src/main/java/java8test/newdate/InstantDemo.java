package java8test.newdate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.chrono.JapaneseDate;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * @Author: wangmeng
 * @Date: 2018/9/27 上午11:04
 */
public class InstantDemo {


    public void test() {
        System.out.println(Instant.ofEpochSecond(3));
        System.out.println(Instant.ofEpochSecond(3, 0));
        System.out.println(Instant.ofEpochSecond(2, 1_000_000_000));
        System.out.println(Instant.ofEpochSecond(4, -1_000_000_000));

        System.out.println(Instant.now().getLong(ChronoField.INSTANT_SECONDS));

        System.out.println(Instant.now().getEpochSecond());

        System.out.println(Instant.MIN);

        System.out.println("-=-=-=-=-=-=-");

        LocalDateTime now = LocalDateTime.of(2017,1,17,0,30,20);
        // JapaneseDate japaneseDate = JapaneseDate.from(now);
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        OffsetDateTime of = OffsetDateTime.of(localDate, localTime, ZoneOffset.ofHours(-1));

        System.out.println(of);

        System.out.println("-=-=-=-=-=-=-=");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = null;
        try {
            parse = sdf.parse("2019-01-31 15:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long epochSecond = Instant.from(LocalDate.now()).getEpochSecond();
        System.out.println(epochSecond);
        System.out.println(Instant.now().getLong(ChronoField.INSTANT_SECONDS));
        System.out.println(parse.toInstant().getEpochSecond());
        boolean after = Instant.now().isAfter(parse.toInstant());
        System.out.println(after);

    }

    public static void main(String[] args) {
        InstantDemo demo = new InstantDemo();
        demo.test();
    }
}
