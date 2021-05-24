package com.tony.redisson;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

/**
 * @author tony121.xu@huolala.cn
 * @create 2021-05-17
 * Description:
 */
public class SingleRedissonLockTemplate implements RedissonLockTemplate {
    private RedissonClient redisson;

    public SingleRedissonLockTemplate() {
    }

    public SingleRedissonLockTemplate(RedissonClient redisson) {
        this.redisson = redisson;
    }

    @Override
    public <T> T lock(RedissonLockCallback<T> callback, boolean fairLock) {
        return lock(callback, DEFAULT_TIMEOUT, DEFAULT_TIME_UNIT, fairLock);
    }

    @Override
    public <T> T lock(RedissonLockCallback<T> callback, long leaseTime, TimeUnit timeUnit, boolean fairLock) {
        RLock lock = getLock(callback.getLockName(), fairLock);
        try {
            lock.lock(leaseTime, timeUnit);
            return callback.process();
        } finally {
            if (lock != null && lock.isLocked()) {
                lock.unlock();
            }
        }
    }

    @Override
    public <T> T tryLock(RedissonLockCallback<T> callback, boolean fairLock) {
        return tryLock(callback, DEFAULT_WAIT_TIME, DEFAULT_TIMEOUT, DEFAULT_TIME_UNIT, fairLock);
    }

    @Override
    public <T> T tryLock(RedissonLockCallback<T> callback, long waitTime, long leaseTime, TimeUnit timeUnit, boolean fairLock) {
        RLock lock = getLock(callback.getLockName(), fairLock);
        try {
            if (lock.tryLock(waitTime, leaseTime, timeUnit)) {
                return callback.process();
            }
        } catch (InterruptedException e) {

        } finally {
            if (lock != null && lock.isLocked()) {
                lock.unlock();
            }
        }
        return null;
    }

    private RLock getLock(String lockName, boolean fairLock) {
        RLock lock;
        if (fairLock) {
            lock = redisson.getFairLock(lockName);
        } else {
            lock = redisson.getLock(lockName);
        }
        return lock;
    }

    public void setRedisson(RedissonClient redisson) {
        this.redisson = redisson;
    }
}
