package spring.advanced.config.v1_proxy.interface_proxy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.advanced.app.proxy.controller.v1.OrderControllerV1;
import spring.advanced.app.proxy.controller.v1.OrderControllerV1Impl;
import spring.advanced.app.proxy.repository.v1.OrderRespositoryV1;
import spring.advanced.app.proxy.repository.v1.OrderRespositoryV1Impl;
import spring.advanced.app.proxy.service.v1.OrderServiceV1;
import spring.advanced.app.proxy.service.v1.OrderServiceV1Impl;
import spring.advanced.trace.logtrace.LogTrace;

@Configuration
public class InterfaceProxyConfig {

    @Bean
    public OrderControllerV1 orderControllerV1(LogTrace logTrace){
        OrderControllerV1Impl controllerV1 = new OrderControllerV1Impl(orderServiceV1(logTrace));
        return new OrderControllerInterfaceProxy(controllerV1,logTrace);
    }

    @Bean
    public OrderServiceV1 orderServiceV1(LogTrace logTrace){
        OrderServiceV1Impl serviceImpl = new OrderServiceV1Impl(orderRepositoryV1(logTrace));
        return new OrderServiceInterfaceProxy(serviceImpl,logTrace);
    }

    @Bean
    public OrderRespositoryV1 orderRepositoryV1(LogTrace logTrace){
        OrderRespositoryV1Impl repositoryImpl = new OrderRespositoryV1Impl();
        return new OrderRepositoryInterfaceProxy(repositoryImpl,logTrace);
    }

}
