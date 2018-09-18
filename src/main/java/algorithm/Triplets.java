package algorithm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangmeng
 * <p>
 * 需要一个数组中的三胞胎 他们3个相加等于0 并且按照 从小到大的顺序排列
 */
public class Triplets {


    /**
     * 存放小于0的数字
     */
    Map<Integer, Integer> left = new HashMap<>();
    /**
     * 存放等于0的数字
     */
    Map<Integer, Integer> zero = new HashMap<>();
    /**
     * 存放大于0的数字
     */
    Map<Integer, Integer> right = new HashMap<>();


    Integer[] getSumIsZeroOfTriplets(Integer[] arr) {

        for (Integer v : arr) {
            if (v < 0) {
                left.put(v, v);
            } else if (v > 0) {
                right.put(v, v);
            } else {
                zero.put(v, v);
            }
            if (zero.size() == 3) {
                return new Integer[]{0, 0, 0};
            }
            if (zero.size() > 0) {
                for (Map.Entry<Integer, Integer> entry : left.entrySet()) {
                    if (null != right.get(-entry.getKey())) {
                        return new Integer[]{entry.getKey(), 0, -entry.getKey()};
                    }
                }
            } else {
                for (Map.Entry<Integer, Integer> leftMap : left.entrySet()) {
                    for (Map.Entry<Integer, Integer> rightMap : right.entrySet()) {
                        Integer r = leftMap.getKey() + rightMap.getKey();
                        if (r > 0) {
                            if (null != left.get(-r)) {
                                return new Integer[]{left.get(-r), leftMap.getKey(), rightMap.getKey()};
                            }
                        } else if (r < 0) {
                            if (null != right.get(-r)) {
                                return new Integer[]{leftMap.getKey(), right.get(-r), rightMap.getKey()};
                            }
                        }
                    }
                }
            }
        }


        return null;
    }


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{8, 2, 2, -1, -2, -4, 8, -4};
        Triplets triplets = new Triplets();
        for (Integer integer : triplets.getSumIsZeroOfTriplets(arr)) {
            System.out.print(integer + " ");
        }

    }

}
