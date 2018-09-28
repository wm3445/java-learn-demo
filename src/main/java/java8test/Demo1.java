package java8test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangmeng
 * 一个java8 stream api 的简单练习
 */
public class Demo1 {

    List<Data> dataList;

    public Demo1(List<Data> dataList) {
        this.dataList = dataList;
    }

    /**
     * 找出 2011 年 发生 的 所有 交易， 并按 交易额 排序（ 从低 到 高）。
     *
     * @param dataList
     */
    static List<Data> test1(List<Data> dataList) {


        LocalDateTime startDateTime = LocalDateTime.of(2018, 1, 1, 0, 0, 0);
        LocalDateTime endDateTime = LocalDateTime.of(2018, 12, 31, 23, 59, 59);
        dataList = dataList.stream()
                .filter(e -> startDateTime.compareTo(e.getDate()) <= 0 && endDateTime.compareTo(e.getDate()) >= 0)
                .sorted(Comparator.comparing(Data::getAmount))
                .collect(Collectors.toList());

        return dataList;
    }


    /**
     * 交易员都在哪些地方交易过
     *
     * @param dataList
     */
    static List<String> test2(List<Data> dataList) {
        return dataList.stream()
                .map(Data::getAddress)
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * 查找来自清华的交易员 并按照姓名排序
     *
     * @param dataList
     */
    static List<Data> test3(List<Data> dataList) {
        return dataList.stream()
                .filter(e -> "清华".equals(e.getCollege()))
                .distinct()
                .sorted(Comparator.comparing(Data::getName))
                .collect(Collectors.toList());
    }

    /**
     * 返回所有交易员的姓名字符串按照字母排序
     *
     * @param dataList
     * @return
     */
    private static String test4(List<Data> dataList) {
        StringBuilder sb = new StringBuilder();
        return dataList.stream()
                .map(Data::getName)
                .distinct()
                .sorted()
                .collect(Collectors.joining());

    }

    private static boolean isHaveWorkAt(String address, List<Data> dataList) {
        return dataList.stream().anyMatch(e -> address.equals(e.getAddress()));
    }

    /**
     * 打印所有上海的交易金额
     *
     * @param dataList
     */
    static void test5(List<Data> dataList) {
        dataList.stream()
                .filter(e -> "上海".equals(e.getAddress()))
                .map(Data::getAmount)
                .forEach(System.out::println);
    }


    /**
     * 总交易金额
     *
     * @param dataList
     * @return
     */
    static double test6(List<Data> dataList) {
        return dataList.stream().mapToDouble(Data::getAmount).sum();
    }


    static void printList(List<Data> dataList) {
        System.out.println("时间 | 姓名 | 工作地址 | 大学 | 金额");
        for (Data data : dataList) {
            System.out.println(
                    data.getDate().toLocalDate() + " " + data.getName() + " " +
                            data.getAddress() + " " + data.getCollege() + " " +
                            data.getAmount()
            );
        }
    }


    public static void main(String[] args) throws ParseException {
        String fenge = "-=-=-=-=-=-=-=-=-=-==-";
        List<Data> dataList = new ArrayList<>();
        dataList.add(new Data(LocalDateTime.of(2018, 1, 1, 0, 0, 0), 32.00, "上海", "清华", "jimi"));
        dataList.add(new Data(LocalDateTime.of(2018, 2, 3, 0, 0, 0), 64.00, "北京", "北大", "tom"));
        dataList.add(new Data(LocalDateTime.of(2018, 3, 3, 0, 0, 0), 20.00, "深圳", "农大", "wangmeng"));
        dataList.add(new Data(LocalDateTime.of(2018, 4, 3, 0, 0, 0), 120.00, "杭州", "工大", "wangmeng"));
        dataList.add(new Data(LocalDateTime.of(2018, 5, 3, 0, 0, 0), 230.00, "上海", "清华", "tom"));
        dataList.add(new Data(LocalDateTime.of(2018, 6, 3, 0, 0, 0), 230.00, "北京", "工大", "cherry"));
        dataList.add(new Data(LocalDateTime.of(2018, 7, 3, 0, 0, 0), 2000.00, "上海", "工大", "jimi"));
        printList(Demo1.test1(dataList));
        System.out.println(fenge);
        for (String s : Demo1.test2(dataList)) {
            System.out.println(s);
        }
        System.out.println(fenge);
        printList(Demo1.test3(dataList));
        System.out.println(fenge);

        System.out.println(Demo1.test4(dataList));
        System.out.println(fenge);
        System.out.println("有工作在上海的？ " + Demo1.isHaveWorkAt("上海", dataList));
        System.out.println(fenge);
        Demo1.test5(dataList);
        System.out.println(fenge);
        System.out.println(Demo1.test6(dataList));

    }


    static class Data {


        private LocalDateTime date;

        private Double amount;

        private String address;

        private String college;

        private String name;

        public Data(LocalDateTime date, Double amount) {
            this.date = date;
            this.amount = amount;
        }

        public Data(LocalDateTime date, Double amount, String address) {
            this.date = date;
            this.amount = amount;
            this.address = address;
        }

        public Data(LocalDateTime date, Double amount, String address, String college, String name) {
            this.date = date;
            this.amount = amount;
            this.address = address;
            this.college = college;
            this.name = name;
        }

        public LocalDateTime getDate() {
            return date;
        }

        public void setDate(LocalDateTime date) {
            this.date = date;
        }

        public Double getAmount() {
            return amount;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCollege() {
            return college;
        }

        public void setCollege(String college) {
            this.college = college;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
