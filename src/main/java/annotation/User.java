package annotation;

/**
 * @Author: king.wm
 * @Date: 2019-02-13 15:50
 * @Version 1.0
 */
public class User {

    private long id;

    @FieldNameTarget(name = "dbName")
    private String name;

    @FieldNameTarget(name = "dbAge")
    private String age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age='" + age + '\'' +
            '}';
    }
}
