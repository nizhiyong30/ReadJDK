package cn.nzy.AnnonationStudy;

import java.lang.annotation.*;

/**
 * Created by nizy on 2018/10/8.
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}
