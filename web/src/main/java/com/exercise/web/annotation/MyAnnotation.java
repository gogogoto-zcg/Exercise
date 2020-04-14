package com.exercise.web.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/14 0014 15:08
 * @Description : TODO
 */
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.TYPE})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MyAnnotation {

    String value() default "";

    String prefix() default "";

}
