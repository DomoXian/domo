package com.leno.common;

import java.lang.annotation.*;

/**
 * Created by XianGuo
 * Date: 2017-10-12 20:48
 * 无需登录的注解
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NoAuth {

}
