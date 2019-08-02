package gc;

import java.lang.management.ManagementFactory;

/**
 * @Author: king.wm
 * @Date: 2019-03-04 10:32
 * @Version 1.0
 */
public class Main {

    private static int _1M = 1024 * 1024;

    private static int _2M = 2 * 1024 * 1024;

    /***
     * -verbose:gc
     * -XX:+UseSerialGC
     * -Xms20M
     * -Xmx20M
     * -Xmn10M
     * -XX:+PrintGCDetails
     * -XX:SurvivorRatio=8
     * -Dfile.encoding=UTF-8
     *
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // 打印JVM参数
        // System.out.println(ManagementFactory.getRuntimeMXBean().getInputArguments());
        //byte[] allocation1, allocation2, allocation3, allocation4;
        //allocation1 = new byte[2*_1M];
        //allocation2 = new byte[2*_1M];
        //allocation3 = new byte[2*_1M];
        //allocation4 = new byte[4*_1M];
    }
}
