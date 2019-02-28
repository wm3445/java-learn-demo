package annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @Author: king.wm
 * @Date: 2019-02-13 15:52
 * @Version 1.0
 */
public class App {

    public static void main(String[] args) {
        User user = new User();
        Field[] fields = user.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            String fieldName = field.getName();
            if(field.isAnnotationPresent(FieldNameTarget.class)){
                FieldNameTarget fieldAnnotation = field.getAnnotation(FieldNameTarget.class);
                System.out.println(fieldName+" 有注解 = "+fieldAnnotation.name());
                try {
                    setFieldValue(field,user,fieldAnnotation.name());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(fieldName+"  没有注解");
            }
        }

        System.out.println("-=-=-=-=");
        System.out.println(user.toString());

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
