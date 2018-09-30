package classload;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author wangmeng
 */
public class MyClassLoader extends ClassLoader {


    @Override
    protected Class<?> findClass(String name) {
        String myPath = "file:////Users/wangmeng/IdeaProjects/java-learn-demo/target/classes/" + name.replace(".", "/") + ".class";
        System.out.println(myPath);
        byte[] cLassBytes = null;
        Path path = null;
        try {
            path = Paths.get(new URI(myPath));
            cLassBytes = Files.readAllBytes(path);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        Class clazz = defineClass(name, cLassBytes, 0, cLassBytes.length);
        return clazz;
    }

    public static void main(String[] args) {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> appClass = myClassLoader.findClass("classload.Main");
        System.out.println(appClass.getClassLoader());
        System.out.println(appClass == App.class);

    }

}
