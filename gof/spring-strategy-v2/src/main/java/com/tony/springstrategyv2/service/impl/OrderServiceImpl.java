package com.tony.springstrategyv2.service.impl;

import com.tony.springstrategyv2.model.OrderDTO;
import com.tony.springstrategyv2.service.IOrderService;
import org.springframework.stereotype.Service;

/**
 * @Author: tony
 * @Description:
 * @Date: Created in 8:54 2021/7/23
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Override
    public String handle(OrderDTO dto) {
        String type = dto.getType();
        if ("1".equals(type)) {
            return "处理普通订单";
        } else if ("2".equals(type)) {
            return "处理团购订单";
        } else if ("3".equals(type)) {
            return "处理促销订单";
        }
        return null;
    }

}
