package com.tony.springstrategyv2.handler.biz;


import com.tony.springstrategyv2.handler.AbstractHandler;
import com.tony.springstrategyv2.handler.HandlerType;
import com.tony.springstrategyv2.model.OrderDTO;
import org.springframework.stereotype.Component;

/**
 * @Author: tony
 * @Description: 促销订单处理器
 * @Date: Created in 8:17 2021/7/23
 */
@Component
@HandlerType("3")
public class PromotionHandler extends AbstractHandler {

    @Override
    public String handle(OrderDTO dto) {
        return "处理促销订单";
    }

}
