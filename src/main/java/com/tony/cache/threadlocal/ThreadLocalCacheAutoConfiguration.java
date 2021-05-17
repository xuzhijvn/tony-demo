package com.tony.cache.threadlocal;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ThreadLocalCacheAutoConfiguration implements WebMvcConfigurer {
    @Bean
    public FilterRegistrationBean idempotentParamtFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        ThreadLocalCacheFilter filter = new ThreadLocalCacheFilter();
        registration.setFilter(filter);
        registration.addUrlPatterns("/cache/threadlocal/*");
        registration.setName("thread-local-cache-filter");
        registration.setOrder(1);
        return registration;
    }
    @Bean
    public ThreadLocalCacheAspect threadLocalCacheAspect() {
        return new ThreadLocalCacheAspect();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HttpInterceptor2()).addPathPatterns("/cache/threadlocal/*");
        registry.addInterceptor(new HttpInterceptor1()).addPathPatterns("/cache/threadlocal/*");
    }
}