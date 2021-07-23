package com.tony.springstrategyv2.handler;

import java.lang.annotation.*;

/**
 * @Author: tony
 * @Description:
 * @Date: Created in 8:07 2021/7/23
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface HandlerType {

    String value();

}
