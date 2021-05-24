package com.tony.redislockregistry;

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
@RequestMapping("/redis-lock-registry")
public class TestController {
    @Resource
    TestService testService;

    @RequestMapping("/test1")
    public String test1(){
        String res = testService.dealAction1("xuzhijun", null);
        return res;
    }
    @RequestMapping("/test2/{id}")
    public String test2(@PathVariable(value="id") String id){
        String res = testService.dealAction2(id, null);
        return res;
    }
    @RequestMapping("/test3")
    public String test3(){
        User user = new User();
        user.setId("430621199201219478");
        user.setName("tony-xu");
        String res = testService.dealAction3(user, null);
        return res;
    }
}
