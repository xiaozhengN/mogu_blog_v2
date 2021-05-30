package com.moxi.mogublog.admin.annotion.TimeCalculator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: zWX1038562
 * @create: 2021-05-30 16:37
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TimeCalculator {
    String value() default "";
}
