package spring.advanced.config.proxy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.advanced.app.proxy.controller.v1.OrderControllerV1;
import spring.advanced.app.proxy.controller.v1.OrderControllerV1Impl;
import spring.advanced.app.proxy.repository.v1.OrderRespositoryV1;
import spring.advanced.app.proxy.repository.v1.OrderRepositoryV1Impl;
import spring.advanced.app.proxy.service.v1.OrderServiceV1;
import spring.advanced.app.proxy.service.v1.OrderServiceV1Impl;

@Configuration
public class V1Config {

    @Bean
    public OrderControllerV1 orderControllerV1(){
        return new OrderControllerV1Impl(orderServiceV1());
    }

    @Bean
    public OrderServiceV1 orderServiceV1() {
        return new OrderServiceV1Impl(orderRepositoryV1());
    }

    @Bean
    public OrderRespositoryV1 orderRepositoryV1() {
        return new OrderRepositoryV1Impl();
    }

}
