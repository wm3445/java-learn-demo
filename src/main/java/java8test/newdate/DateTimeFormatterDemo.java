package java8test.newdate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
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


    }
}
