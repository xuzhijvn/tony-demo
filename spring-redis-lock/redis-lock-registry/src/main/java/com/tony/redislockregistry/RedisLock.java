package com.tony.redislockregistry;

/**
 * @author tony121.xu@huolala.cn
 * @create 2021-05-17
 * Description:
 */

import java.lang.annotation.*;

/**
 * 用于标记redis锁
 * created at 2019-07-05 15:15
 * @author lerry
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisLock {

    /**
     * 可使用SpEL传方法参数
     * @return
     */
    String value() default "";

    /**
     * redis锁的key值
     * @return
     */
    String lockKey() default "";
}
