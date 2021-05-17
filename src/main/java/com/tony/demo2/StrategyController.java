package com.tony.demo2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tony121.xu@huolala.cn
 * @create 2021-05-01
 * Description:
 */
@RestController
public class StrategyController {
    @Resource
    SensitiveStrategyService sensitiveStrategyService;

    @RequestMapping("/strategy")
    public String retry(){
        String res = sensitiveStrategyService.generatorSensitive(SensitiveType.MOBILE_PHONE,"15521045900");
        return res;
    }
}
