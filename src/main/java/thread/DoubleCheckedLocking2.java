package thread;

/**
 * @Author: wangmeng
 * @Date: 2018/9/30 下午1:57
 */
public class DoubleCheckedLocking2 {

    private static class HelperContainer{
        private static Helper helper = new Helper();
    }

    public Helper getHelper() {
        return HelperContainer.helper;
    }


}
