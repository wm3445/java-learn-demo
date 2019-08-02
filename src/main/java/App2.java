import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;

/**
 * @Author: king.wm
 * @Date: 2019-03-06 11:45
 * @Version 1.0
 */
public class App2 {

    public static void main(String[] args) throws IOException {
        System.out.println("-=-=-=-=-=");
        String packageName = "aop";
        Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(packageName);
        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            System.out.println(url.getPath()+" "+url.getProtocol());
            String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
            System.out.println(filePath);
        }
    }
}
