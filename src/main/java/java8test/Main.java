package java8test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntConsumer;

import static java.util.stream.Collectors.toList;

/**
 * @Author: wangmeng
 * @Date: 2018/10/11 下午5:13
 */
public class Main {

    public void print(int a, IntConsumer intConsumer) {
        intConsumer.accept(a);
    }

    public static void main(String[] args) {

        int b = 100;
        int finalB = b;
        IntConsumer intConsumer = (int a) -> {
            System.out.println(a);
            System.out.println(finalB);
        };
        b = 50;

        Main main = new Main();
        main.print(2, intConsumer);
        System.out.println(b);

        System.out.println("-=--=-=-=-=-");
        Map<Long, Integer[]> ouGroupMap = new HashMap<>();
        List<String> keys = new ArrayList<>();
        keys.add("1");
        keys.add("2");
        keys.add("3");
        keys.add("1");
        keys.add("1");

        for (String key1 : keys) {
            if (null == ouGroupMap.get(Long.valueOf(key1))) {
                ouGroupMap.put(Long.valueOf(key1),new Integer[]{0,0,0,0});
            } else {
                Integer[] integers = ouGroupMap.get(Long.valueOf(key1));
                integers[0] += 1;
                integers[1] += 1;

            }

        }

        for (String key1 : keys) {
            if (null == ouGroupMap.get(Long.valueOf(key1))) {
                ouGroupMap.put(Long.valueOf(key1),new Integer[]{0,0,0,0});
            } else {
                Integer[] integers = ouGroupMap.get(Long.valueOf(key1));
                integers[2] += 1;
                integers[3] += 10;

            }

        }


        for (Map.Entry<Long, Integer[]> longEntry : ouGroupMap.entrySet()) {
            System.out.println("key ->>>>"+longEntry.getKey());

            Integer[] value = longEntry.getValue();
            for (Integer integer : value) {
                System.out.println(integer);
            }
            System.out.println("################");

        }



        int a = 7/3;
        System.out.println(a);

        System.out.println("-=-=-=");

        List<String > cacheList = new ArrayList<>();
        for (int i = 1; i <= 1001; i++) {
            cacheList.add(i+"");
        }


        List<List<String>> lists = splitCacheList(cacheList);
        System.out.println(lists.size());

        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println("-=-=-="+list.size());
        }
    }

    public static  <T> List<List<T>> splitCacheList(List<T> cacheList) {
        List<List<T>> result = new ArrayList<>();
        int cacheCount = (int)Math.ceil((double)cacheList.size() / 3.0) ;
        for (int i = 0; i < cacheList.size(); i++) {
            if (i % cacheCount == 0) {
                List<T> tList = cacheList.stream().skip(i).limit(cacheCount).collect(toList());
                result.add(tList);
            }
        }
        return result;
    }
}
