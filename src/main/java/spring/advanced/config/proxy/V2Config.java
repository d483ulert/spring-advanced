package spring.advanced.config.proxy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.advanced.app.proxy.controller.v2.OrderControllerV2;
import spring.advanced.app.proxy.repository.v2.OrderRepositoryV2;
import spring.advanced.app.proxy.service.v2.OrderServiceV2;

@Configuration
public class V2Config {

    @Bean
    public OrderControllerV2 orderControllerV2(){
        return new OrderControllerV2(orderServiceV2());
    }

    @Bean
    public OrderServiceV2 orderServiceV2() {
        return new OrderServiceV2(orderRepositoryV2());
    }

    @Bean
    public OrderRepositoryV2 orderRepositoryV2() {
        return new OrderRepositoryV2();
    }

}
