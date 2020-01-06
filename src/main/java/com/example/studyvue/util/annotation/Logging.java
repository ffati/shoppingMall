package com.example.studyvue.util.annotation;

import java.lang.annotation.*;

/**
 * @ClassName Logging
 * @Description TODO
 * @Author ff
 * @Date 2020/1/6 15:38
 * @ModifyDate 2020/1/6 15:38
 * @Version 1.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface Logging {

    String description() default "";

}
