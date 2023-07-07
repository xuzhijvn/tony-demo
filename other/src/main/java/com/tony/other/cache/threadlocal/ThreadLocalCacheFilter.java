package com.tony.other.cache.threadlocal;

import lombok.extern.slf4j.Slf4j;
import javax.servlet.*;
import java.io.IOException;

/**
 * 线程缓存过滤器
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-07-12 19:46
 */
@Slf4j
public class ThreadLocalCacheFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("我是Filter.init方法");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("我是Filter.doFilter方法");

        filterChain.doFilter(servletRequest, servletResponse);
        // 执行完后清除缓存
        ThreadLocalCacheManager.removeCache();
    }

    @Override
    public void destroy() {
        System.out.println("我是Filter.destroy方法");
    }
}