package com.tony.springstrategyv2.service.impl;

import com.tony.springstrategyv2.handler.AbstractHandler;
import com.tony.springstrategyv2.handler.HandlerContext;
import com.tony.springstrategyv2.model.OrderDTO;
import com.tony.springstrategyv2.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: tony
 * @Description:
 * @Date: Created in 8:54 2021/7/23
 */
@Service
public class OrderServiceV2Impl implements IOrderService {

    @Autowired
    private HandlerContext handlerContext;

    @Override
    public String handle(OrderDTO dto) {
        AbstractHandler handler = handlerContext.getInstance(dto.getType());
        return handler.handle(dto);
    }

}
