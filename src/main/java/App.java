import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangmeng
 * @Date: 2018/9/30 上午10:50
 */
public class App {


    private Integer id;




    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }
        System.out.println(list);
    }


    enum ProcessStatusEnum {





    }
}
