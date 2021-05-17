package com.tony.redisson;

/**
 * @author tony121.xu@huolala.cn
 * @create 2021-05-17
 * Description:
 */
/**
 * 分布式锁回调接口
 */
public interface DistributedLockCallback<T> {
    /**
     * 调用者必须在此方法中实现需要加分布式锁的业务逻辑
     *
     * @return
     */
    public T process();

    /**
     * 得到分布式锁名称
     *
     * @return
     */
    public String getLockName();
}
