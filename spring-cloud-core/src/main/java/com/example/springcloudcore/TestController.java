package com.example.springcloudcore;

import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tony老师
 * @create 2021-05-01
 * Description:
 */
@RestController
public class TestController {
    @Resource
    private RefreshScope refreshScope;

    @Resource
    private User user;


    @RequestMapping("/refresh")
    public String refresh(){
        System.out.println(user);
        refreshScope.refresh("user");
        System.out.println(user);
        return "ok";
    }
    @RequestMapping("/fresh")
    public String fresh(){
        //refreshScope.refresh("user");
        System.out.println(user);
        System.out.println(user);
        return "ok";
    }
}
