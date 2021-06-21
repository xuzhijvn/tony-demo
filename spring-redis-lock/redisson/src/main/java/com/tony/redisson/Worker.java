package com.tony.redisson;

import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;

import java.util.concurrent.CountDownLatch;

/**
 * @author tony老师
 * @create 2021-05-17
 * Description:
 */
public class Worker implements Runnable {

    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;
    private final TestService testService;
    private RedissonClient redissonClient;

    public Worker(CountDownLatch startSignal, CountDownLatch doneSignal, TestService testService, RedissonClient redissonClient) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
        this.testService = testService;
        this.redissonClient = redissonClient;
    }

    @Override
    public void run() {
        try {
            startSignal.await();

            System.out.println(Thread.currentThread().getName() + " start");

//            Integer count = service.aspect(new Person(1, "张三"));
//            Integer count = service.aspect("1");

            Person person = new Person();
            person.setId(783175223);
            person.setName("tony");

            Integer count = testService.doSomething3(() -> work(), person);

            System.out.println(Thread.currentThread().getName() + ": count = " + count);

            doneSignal.countDown();

        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }
    private int work() {
        RMap<String, Integer> map = redissonClient.getMap("distributionTest");

        Integer count1 = map.get("count");
        if (count1 > 0) {
            count1 = count1 - 1;
            map.put("count", count1);
        }
        return count1;
    }

}