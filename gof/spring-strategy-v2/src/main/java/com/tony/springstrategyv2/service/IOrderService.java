package com.tony.springstrategyv2.service;

import com.tony.springstrategyv2.model.OrderDTO;

/**
 * @Author: tony
 * @Description:
 * @Date: Created in 8:51 2021/7/23
 */
public interface IOrderService {

    /**
     * 根据订单的不同类型作出不同的处理
     *
     * @param dto 订单实体
     * @return 为了简单，返回字符串
     */
    String handle(OrderDTO dto);

}
