/*
 *       Copyright© (2020).
 */
package com.tony;


import java.util.concurrent.*;

/**
 * @author tony
 * @create 2021-10-24
 * @description:
 */
public class ParallelTaskExecutor implements Executor{



    /**
     * @param capacity 最多可同时执行的任务个数
     */
    public ParallelTaskExecutor(int capacity) {
        // show me your code here

    }

    /**
     * 异步执行任务, 返回 Future 对象
     *
     * @param callable 要执行的任务
     * @param <T>      任务的返回值类型
     * @return 返回一个 Future, 任务执行完成时其状态变更为 Done.
     */
    public <T> Future<T> submit(Callable<T> callable) {
        // show me your code here, please delete the following line.
        RunnableFuture<T> ftask = newTaskFor(callable);
        execute(ftask);
        return ftask;
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new FutureTask<T>(callable);
    }

    @Override
    public void execute(Runnable command) {

    }
}
