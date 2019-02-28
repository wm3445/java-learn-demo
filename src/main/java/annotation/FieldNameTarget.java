package annotation;

import java.lang.annotation.*;

/**
 * 有的时候我们需要通过反射的形式给字段赋值，通过数据库中的字段名称和实体类中的名称保持一致 <br/>
 * 但这就相当于隐藏了一部分逻辑，如果以后数据库字段名称变更就会产生问题 因此可以定义一个注解通过注解的方式解耦
 *
 * @Author: king.wm
 * @Date: 2019-02-13 15:43
 * @Version 1.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Inherited
public @interface FieldNameTarget {

     String name() default "";
}
