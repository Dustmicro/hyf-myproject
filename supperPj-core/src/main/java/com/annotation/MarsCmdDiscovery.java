package com.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(MarsCmdDiscoveryRegistrar.class)
public @interface MarsCmdDiscovery {
    String[] basePackages() default {};

    String[] value() default {};

    Class<?> cmdPublishClass();
}
