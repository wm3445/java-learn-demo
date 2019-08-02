package classload;

public class App {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        String property = System.getProperty("user.dir");
        System.out.println(property);
    }
}
