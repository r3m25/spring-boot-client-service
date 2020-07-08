package com.r3m25.client.configuration.anotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Adapter {
    @AliasFor(
            annotation = Component.class
    )
    String value() default "";
}
