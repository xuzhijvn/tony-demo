package com.tony.demo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author tony老师
 * @create 2021-05-01
 * Description:
 */
@Service
public class UserService2 {

    @Value("${hll.dispatch.url}")
    private String url;


    public String retry() {
        return "url :" + this.url;
    }

}
