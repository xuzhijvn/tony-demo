package com.tony.mysql.tx.isolation.generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.mysql.tx.isolation.generator.domain.Good;
import com.tony.mysql.tx.isolation.generator.domain.Order;
import com.tony.mysql.tx.isolation.generator.mapper.OrderMapper;
import com.tony.mysql.tx.isolation.generator.service.GoodService;
import com.tony.mysql.tx.isolation.generator.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
        implements OrderService {

    @Resource
    GoodService goodService;

    @Override
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.SERIALIZABLE)
    public void doOrder() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + ": 开始事务");
        Good good = goodService.getById(1);
        System.out.println(Thread.currentThread().getName() + ": 商品=" + good.getGoodName() + ",剩余商品数量= " + good.getGoodNum());
        good.setGoodNum(good.getGoodNum() - 1);
        goodService.updateById(good);
        System.out.println(Thread.currentThread().getName() + ": 更新商品数量为 = " + (good.getGoodNum()));
        Thread.sleep(20_000);
        System.out.println(Thread.currentThread().getName() + ": 结束事务");
    }
}




