package com.tony.cache.threadlocal;

import com.tony.demo3.HelloService2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tony121.xu@huolala.cn
 * @create 2021-05-01
 * Description:
 */
@RestController
@Slf4j
@RequestMapping("/cache")
public class CacheThreadLocalController {
    @Resource
    TestService testService;

    @RequestMapping("/threadlocal")
    public String threadlocal1(){
        String res = testService.getName();
        return res;
    }
    @RequestMapping("/threadlocal/{id}")
    public String threadlocal2(@PathVariable(value="id") String id){
        String res = testService.getName(id);
        return res;
    }
}
