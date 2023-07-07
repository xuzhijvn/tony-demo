package com.tony.other.demo3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author tony老师
 * @create 2021-05-08
 * Description:
 */
@Service
@Slf4j
public abstract class HelloServiceTimeOut extends HelloServiceReject{

    @Override
    public void handle() {
        mySay2();
    }
}
