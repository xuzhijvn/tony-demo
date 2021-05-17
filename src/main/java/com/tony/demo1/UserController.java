package com.tony.demo1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tony121.xu@huolala.cn
 * @create 2021-05-01
 * Description:
 */
@RestController
public class UserController {
    @Resource
    UserService userService;

    @Resource
    UserService2 userService2;

    @RequestMapping("/retry")
    public String retry(){
        String url = userService.url;
        System.out.println(url);
        String res = userService.retry();
        return res;
    }
    @RequestMapping("/retry2")
    public String retry2(){
        return userService2.retry();
    }
}
