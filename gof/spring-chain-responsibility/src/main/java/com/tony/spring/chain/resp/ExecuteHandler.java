/*
 *       Copyright© (2020).
 */
package com.tony.spring.chain.resp;


import cn.hutool.core.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tony
 * @create 2021-08-08
 * @description:
 */

@Component
public class ExecuteHandler {

    @Autowired
    private ApplicationContext context;

    private List<Handler> handlerList = new LinkedList<>();

    private Handler handler;

    public Handler getHandler() {
        return handler;
    }

    /**
     * 该方法会在该对象创建之后被调用
     */
    @PostConstruct
    public void afterPostConstruct() {
        //添加所有自定义handler到list
        HandlerBeanEnum[] values = HandlerBeanEnum.values();
        for (HandlerBeanEnum value : values) {
            Handler bean = context.getBean(value.getBeanName(), Handler.class);
            handlerList.add(bean);
        }
        //handler根据@Order排序，值越小优先级越高
        if (CollectionUtil.isNotEmpty(handlerList)) {
            handlerList.sort(AnnotationAwareOrderComparator.INSTANCE);
            for (int i = 1; i < handlerList.size(); i++) {
                //当前处理器
                Handler currentHandler = handlerList.get(i - 1);
                //下一个处理器
                Handler nextHandler = handlerList.get(i);
                //将处理器串成链表
                currentHandler.setNextHandler(nextHandler);

                //自定义的最后一个handler指向系统兜底handler
                if (i == handlerList.size() -1){
                    nextHandler.setNextHandler(new Handler() {
                        @Override
                        void dealRequest(Integer num) {
                            System.out.println("系统兜底handler");
                        }
                    });
                }
            }
            this.handler = handlerList.get(0);
        }
    }
}