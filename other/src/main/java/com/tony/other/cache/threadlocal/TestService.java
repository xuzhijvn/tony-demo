package com.tony.other.cache.threadlocal;

import org.springframework.stereotype.Service;

@Service
public class TestService {
    /**
     * ThreadLocalCache 会缓存，只对当前线程有效
     * @return
     */
    @ThreadLocalCache
    public String getName() {
        System.out.println("开始查询了");
        return "yinjihaun";
    }
    /**
     * 支持SPEL表达式
     * @param id
     * @return
     */
    @ThreadLocalCache(key = "#id")
    public String getName(String id) {
        System.out.println("开始查询了");
        return "yinjihaun" + id;
    }
}