package com.tony.demo1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @author tony121.xu@huolala.cn
 * @create 2021-05-01
 * Description:
 */
@Service
@Slf4j
public class UserService implements UserInterface{

    @Value("${hll.dispatch.url}")
    public String url;


    @Override
    @Retryable(maxAttempts = 2)
    public String retry() {
        log.info("hello world");
        return "url :" + this.url;
    }

}
