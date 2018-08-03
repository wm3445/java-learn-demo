package gc;

public class demo1 {


    private static int _1M = 1024 * 1024;

    /**
     * VM参数 -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
     */
    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1M];
        allocation2 = new byte[2 * _1M];
        allocation3 = new byte[2 * _1M];
        allocation4 = new byte[4 * _1M];
    }


}
