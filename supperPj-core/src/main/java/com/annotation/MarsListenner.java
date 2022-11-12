package com.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 侦听
 * @author 黄弋峰 2022/11/12
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MarsListenner {
    @AliasFor("name")
    String value() default "";

    @AliasFor("value")
    String name() default "";
}
