package com.tony.springstrategyv2;

import com.tony.springstrategyv2.model.OrderDTO;
import com.tony.springstrategyv2.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/spring-strategy-v2")
public class SpringStrategyV2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringStrategyV2Application.class, args);
    }

    @Qualifier("orderServiceV2Impl")
    @Autowired
    private IOrderService orderService;

    @RequestMapping("/handle")
    public Object handle(@RequestBody OrderDTO dto) {
        return orderService.handle(dto);
    }
}
