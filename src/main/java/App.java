import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.NumberFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Author: king.wm
 * @Date: 2019-01-02 15:23
 * @Version 1.0
 */
public class App {

    public static void main(String[] args) {
        List<User> list1 = new ArrayList<>();
        list1.add(new User(1, "wang", new Date(), 0.21));
        list1.add(new User(2, "wang1", new Date(), 0.22));
        list1.add(new User(3, "wang2", new Date(), 0.23));
        list1.add(new User(4, "wang32", new Date(), 0.24));
        list1.add(new User(5, "wang4", new Date(), 0.25));
        list1.add(new User(6, "wang5", new Date(), 0.26));

        List<User> list2 = new ArrayList<>();
        list2.add(new User(1, "wang", new Date(), 0.21));


        a:
        for (User user : list1) {
            System.out.println("开始执行");
            b:
            for (User user1 : list2) {
                if (Objects.equals(user.getId(), user1.getId())) {
                    System.out.println(user);
                    continue a;
                }
            }
            System.out.println("继续执行");
        }


        String num = String.format("%02d", Long.valueOf(1));
        System.out.println(num);


        String text = "PRE_POST_EURO_WRT_EXCH_RT\n" +
                "PRE_POST_EURO_WRT_UNDL_EXCH_RT\n" +
                "PRE_EURO_WRT_EXR_PX\n" +
                "POST_EURO_WRT_EXR_PX\n" +
                "PRE_EURO_WRT_UNDL_ISIN\n" +
                "POST_EURO_WRT_UNDL_ISIN\n" +
                "PRE_EURO_WRT_DIVISOR\n" +
                "POST_EURO_WRT_DIVISOR\n" +
                "WRT_DIVISOR\n" +
                "WRT_TYP\n" +
                "WRT_CALC_TYP\n" +
                "SETTLEMENT_CURRENCY\n" +
                "WRT_UNDL_UNIQUE_ID\n" +
                "WRT_UNDL_COMPANY_ID\n" +
                "WRT_UNDL_SECURITY_ID\n" +
                "WRT_EXPIRE_TIME_ZONE\n" +
                "EXPIRE_TIME\n" +
                "WRT_DEBENTURE\n" +
                "WRT_OUTSTANDING\n" +
                "INITIAL_FUNDING_RATE_BENCHMARK\n" +
                "INITIAL_FUNDING_RATE_SPREAD\n" +
                "INITIAL_FUNDING_RATE\n" +
                "RESIDUAL_VALUE\n" +
                "NUMBER_OF_WARRANTS_BOUGHT\n" +
                "NUMBER_OF_WARRANTS_SOLD\n" +
                "AVG_PRICE_PER_WARRANTS_BOUGHT\n" +
                "AVG_PRICE_PER_WARRANTS_SOLD\n" +
                "SETTLEMENT_CALENDAR_CODE\n" +
                "CALENDAR_START_DATE";

        String[] split = text.split("\n");
        for (int i = 0; i < split.length; i++) {
            if ((i + 1) % 10 == 0 || i + 1 == split.length) {
                System.out.println(split[i]);
            }
        }
        System.out.println("-=-=-=-=-=-");

        for (int i = 0; i < split.length; i++) {
            if (i != 0 && 10 % i == 0) {
                System.out.println(split[i]);
            }
        }

        int a = 10;
        for (int i = 1; i <= 200; i++) {
            int b = i % a;

            if (b == 0) {
                b = a;
            }
            System.out.println(b);

        }


        String s = User.get();
        System.out.println(s);



        NumberFormat nf = NumberFormat.getPercentInstance();


        nf.setMinimumFractionDigits(2);

        String format = nf.format(0.106492D);

        System.out.println(format);

        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        Date date = new Date();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime from = LocalDateTime.ofInstant(instant, zone);
        String format1 = dateTimeFormatter.format(from);
        System.out.println(format1);

        System.out.println("=-=-=-=-=-=-=-=-");
        BigDecimal bigDecimal = new BigDecimal(".01");
        System.out.println(bigDecimal.toString());

        String yyyyMMdd = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        System.out.println(yyyyMMdd);

        System.out.println("-=-=-=-=-");
        String str = "FX201901060148";
        String no = str.replace("FX", "").substring(0,8);
        System.out.println("no "+no);

        System.out.println("-=--=-=-=-=-=-=-=-=");
        String string = "4343 asdasd";
        String s1 = transformNullStr(string);
        System.out.println(s1);

        System.out.println("==-=-=-=-=-=-=-=-=-=");
        String currencyPair = "USD";
        String currency = "CNYUSD BFIX Curncy";
        currency = currency.replace("BFIX", "")
            .replace("Curncy", "")
            .replace(" ", "")
            .replace(currencyPair,"/"+currencyPair);
        System.out.println(currency);

        System.out.println("-=-=-=-=-=-=-=-=");

        try {
            InetAddress addr = InetAddress.getLocalHost();
            System.out.println(addr);
            System.out.println(addr.getHostAddress());
            System.out.println(addr.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        System.out.println("-=-=-=-=-=");
        System.out.println();
        for (int i = 0; i < 1000; i++) {
            if (i % 999 == 998) {
                System.out.println(i);
            }
        }


    }

    static class User {


        long id;

        String name;

        Date date;

        Double amount;

        User() {
            System.out.println("-=-=-=-==-");
        }

        public User(long id, String name, Date date, Double amount) {
            this.id = id;
            this.name = name;
            this.date = date;
            this.amount = amount;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Double getAmount() {
            return amount;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", date=" + date +
                    ", amount=" + amount +
                    '}';
        }


        public static String get() {

            return "hello";
        }
    }


    private static String transformNullStr(String string){
        if (Objects.nonNull(string)) {
            String replace = string.replace(" ", "");
            if (replace.length() == 0) {
                return null;
            }
        }
        return string;
    }

}
