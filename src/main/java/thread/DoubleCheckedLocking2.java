package thread;

/**
 * @Author: wangmeng
 * @Date: 2018/9/30 下午1:57
 */
public class DoubleCheckedLocking2 {

    private DoubleCheckedLocking2() {

        System.out.println("DoubleCheckedLocking2 init");
    }

    private static class HelperContainer {
        HelperContainer() {
            System.out.println("HelperContainer init ");
        }
        private static Helper helper = new Helper();
    }

    public static Helper getHelper() {
        return HelperContainer.helper;
    }

    public static void main(String[] args) {
        DoubleCheckedLocking2 checkedLocking2 = new DoubleCheckedLocking2();
        System.out.println("-=-=-=-=-=-=-=-=-");
        Helper helper = DoubleCheckedLocking2.getHelper();
        helper.help();
    }


}
