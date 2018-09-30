package thread;

/**
 * @Author: wangmeng
 * @Date: 2018/9/30 下午1:57
 */
public class DoubleCheckedLocking {

    private volatile Helper helper = null;

    public Helper getHelper() {
        if (helper == null) {
            synchronized (this) {
                if (helper == null) {
                    helper = new Helper();
                }
            }
        }
        return helper;
    }


}
