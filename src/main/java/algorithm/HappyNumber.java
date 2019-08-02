package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wangmeng
 * <p>
 * 是否为快乐数字
 * <p>
 * 快乐数字的算法为
 * <p>
 * 例如 28
 * 2*2+8*8=68
 * 6*6+8*8=100
 * 1*1+0*0+0*0=1
 * 28为快乐数字
 * <p>
 * 11
 * 1*1+1*1=2
 * 2*2=4
 * 4*4=16
 * 1*1+6*6=37
 * 3*3+7*7=58
 * 5*5+8*8=89
 * 8*8+9*9=145
 * 1*1+4*4+5*5=42
 * 4*4+2*2=20
 * 2*2+0*0=2
 * 1*1+1*1=2 和 2*2+0*0=2 重复因此会一直循环下去 所以 11 不是快乐数字
 */
public class HappyNumber {


    public boolean isHappy(int number) {
        Set<Integer> history = new HashSet<>();
        while (number != 1) {
            int sum = 0;
            while (number > 0) {
                sum += (number % 10) * (number % 10);
                number = number / 10;
            }
            if (history.contains(sum)) {
                return false;
            } else {
                history.add(sum);
            }
            number = sum;
        }
        return true;
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println("快乐数字 ？ " + happyNumber.isHappy(28));
        System.out.println("快乐数字 ？ " + happyNumber.isHappy(11));
        System.out.println("快乐数字 ？ " + happyNumber.isHappy(37));

        StringBuilder sb = new StringBuilder().append("a").append("b").append("c");

    }


}
