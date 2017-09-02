package org.hhs.annotation;

import java.lang.annotation.*;

/**
 * Created by hewater on 2017/9/2.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
