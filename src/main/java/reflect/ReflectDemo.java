package reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author wangmeng
 * <p>
 * 利用反射实现序列化反序列化
 */
public class ReflectDemo {




    public static void main(String[] args) {
        User user = new User(1, "jimi");
        String toString = toString(user);
        System.out.println(toString);
        Object o = fromString(toString);
        User user1 = (User) o;
        System.out.println(user1.getId() + " " + user1.getName());
    }


    public static String toString(Object obj) {
        Class<?> cls = obj.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getName()).append("\n");
        for (Field f : cls.getDeclaredFields()) {
            if (!f.isAccessible()) {
                f.setAccessible(true);
            }
            try {
                sb.append(f.getName()).append("=").append(f.get(obj).toString()).append("\n");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static Object fromString(String str) {
        try {

            String[] lines = str.split("\n");
            if (lines.length < 1) {
                throw new IllegalArgumentException(str);
            }
            System.out.println(lines[0]);
            Class<?> cls = Class.forName(lines[0]);
            Object obj = cls.newInstance();
            if (lines.length > 1) {
                for (int i = 1; i < lines.length; i++) {
                    String[] fv = lines[i].split("=");
                    if (fv.length != 2) {
                        throw new IllegalArgumentException(lines[i]);
                    }
                    Field f = cls.getDeclaredField(fv[0]);
                    if (!f.isAccessible()) {
                        f.setAccessible(true);
                    }
                    setFieldValue(f, obj, fv[1]);
                }
            }
            return obj;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }


    private static void setFieldValue(Field f, Object obj, String value) throws Exception {
        Class<?> type = f.getType();
        if (type == int.class) {
            f.setInt(obj, Integer.parseInt(value));
        } else if (type == byte.class) {
            f.setByte(obj, Byte.parseByte(value));
        } else if (type == short.class) {
            f.setShort(obj, Short.parseShort(value));
        } else if (type == long.class) {
            f.setLong(obj, Long.parseLong(value));
        } else if (type == float.class) {
            f.setFloat(obj, Float.parseFloat(value));
        } else if (type == double.class) {
            f.setDouble(obj, Double.parseDouble(value));
        } else if (type == char.class) {
            f.setChar(obj, value.charAt(0));
        } else if (type == boolean.class) {
            f.setBoolean(obj, Boolean.parseBoolean(value));
        } else if (type == String.class) {
            f.set(obj, value);
        } else {
            Constructor<?> ctor = type.getConstructor(String.class);
            f.set(obj, ctor.newInstance(value));
        }
    }
}
