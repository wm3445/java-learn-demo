package java8test.newdate;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;

/**
 * @Author: wangmeng
 * @Date: 2018/9/27 下午1:02
 */
public class DateTimeFormatterDemo {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date1 = LocalDate.of(2018, 9, 27);
        String formatDate1 = date1.format(formatter);
        System.out.println("formatDate1:" + formatDate1);
        LocalDate date2 = LocalDate.parse(formatDate1, formatter);
        System.out.println(date1 + "   " + date2);

        System.out.println("-=-=-=-=-=-=-=-=-");

        DateTimeFormatter italianFormatter = new DateTimeFormatterBuilder()
            .appendText(ChronoField.DAY_OF_WEEK)
            .appendLiteral(".  ")
            .appendText(ChronoField.MONTH_OF_YEAR)
            .appendLiteral(" ")
            .appendText(ChronoField.YEAR)
            .parseCaseInsensitive()
            .toFormatter(Locale.CHINA);
        String format = date1.format(italianFormatter);
        System.out.println(format);

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String format1 = formatter1.format(LocalDateTime.now());
        System.out.println(format1);

        System.out.println("-=-=-=-=getLastUpdate start-=-=-=-=-");

        String tokyoDate = "20190224";
        String tokyoTime = "23:59:34";
        Date lastUpdate = getLastUpdate(tokyoDate, tokyoTime);
        System.out.println(lastUpdate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format2 = sdf.format(lastUpdate);
        System.out.println(format2);
        System.out.println("--=-=-=-=-getLastUpdate end");

        LocalDate startDate = LocalDate.parse("2019-05-05", DateTimeFormatter.ISO_LOCAL_DATE);

        LocalDateTime localDateTime= LocalDateTime.parse("2019-05-05T23:59:59", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(startDate);
        System.out.println(localDateTime);

        System.out.println(DateTimeFormatter.BASIC_ISO_DATE.toString());

    }

    private static Date getLastUpdate(String tokyoDate, String tokyoTime) {
        LocalTime localTime = getTokyoTime(tokyoTime);
        LocalDate localDate = LocalDate.from(DateTimeFormatter.ofPattern("yyyyMMdd").parse(tokyoDate));
        LocalDateTime of = LocalDateTime.of(localDate, localTime);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = of.atZone(zone).toInstant();
        return Date.from(instant);
    }

    private static LocalTime getTokyoTime(String tokyoTime) {
        String[] split = tokyoTime.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        int second = Integer.parseInt(split[2]);
        return LocalTime.of(hour, minute, second);
    }
}
