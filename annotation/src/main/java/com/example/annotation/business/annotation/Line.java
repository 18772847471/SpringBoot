package com.example.annotation.business.annotation;


import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Line {
    int line() default 3;
}
