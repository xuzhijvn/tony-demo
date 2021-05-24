package com.tony.redisson;

import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;

/**
 * @author tony121.xu@huolala.cn
 * @create 2021-05-17
 * Description:
 */
@RestController
@RequestMapping("/distributedLockTest")
public class TestController {

    @Autowired
    private TestService testService;

    private int count = 10;

    @Autowired
    private RedissonClient redissonClient;


    @RequestMapping(method = RequestMethod.GET)
    public String distributedLockTest() throws Exception {

        RMap<String, Integer> map = redissonClient.getMap("distributionTest");
        map.put("count", 8);

        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(count);

        for (int i = 0; i < count; ++i) {
            new Thread(new Worker(startSignal, doneSignal, testService, redissonClient)).start();
        }

        startSignal.countDown(); // let all threads proceed
        doneSignal.await();
        System.out.println("All processors done. Shutdown connection");

        return "finish";
    }

}
