package com.tony.springstrategyv2.handler;


import com.tony.springstrategyv2.model.OrderDTO;

/**
 * @Author: tony
 * @Description:
 * @Date: Created in 8:57 2021/7/23
 */
public abstract class AbstractHandler {

    abstract public String handle(OrderDTO dto);

}
