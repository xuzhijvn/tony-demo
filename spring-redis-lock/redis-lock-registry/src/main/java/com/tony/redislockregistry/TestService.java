package com.tony.redislockregistry;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author tony121.xu@huolala.cn
 * @create 2021-05-17
 * Description:
 */

@Service
public class TestService {

    @RedisLock(lockKey = "T(com.tony.redislockregistry.Constant).REDIS_KEY_DEAL_ACTION")
    public String dealAction1(String key, String errorMsg) {
        // 对应切面中的 arguments[1] = "已有任务正在执行，请勿重复请求";
        if (StrUtil.isNotEmpty(errorMsg)) {
            return errorMsg;
        }
        // 模拟方法执行耗时
        ThreadUtil.safeSleep(5000);
        // xxx 具体执行代码 省略
        return "hello dealAction1";
    }
    @RedisLock(lockKey = "#key")
    public String dealAction2(String key, String errorMsg) {
        // 对应切面中的 arguments[1] = "已有任务正在执行，请勿重复请求";
        if (StrUtil.isNotEmpty(errorMsg)) {
            return errorMsg;
        }
        // 模拟方法执行耗时
        ThreadUtil.safeSleep(5000);
        // xxx 具体执行代码 省略
        return "hello dealAction2";
    }
    @RedisLock(lockKey = "#user.id")
    public String dealAction3(User user, String errorMsg) {
        // 对应切面中的 arguments[1] = "已有任务正在执行，请勿重复请求";
        if (StrUtil.isNotEmpty(errorMsg)) {
            return errorMsg;
        }
        // 模拟方法执行耗时
        ThreadUtil.safeSleep(5000);
        // xxx 具体执行代码 省略
        return "hello dealAction2";
    }


}
