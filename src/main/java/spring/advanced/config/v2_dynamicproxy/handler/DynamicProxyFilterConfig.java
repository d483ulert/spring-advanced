package spring.advanced.config.v2_dynamicproxy.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.advanced.app.proxy.repository.v1.OrderRepositoryV1Impl;
import spring.advanced.app.proxy.repository.v1.OrderRespositoryV1;
import spring.advanced.app.proxy.service.v1.OrderServiceV1;
import spring.advanced.app.v1.OrderControllerV1;
import spring.advanced.app.v1.OrderRepositoryV1;
import spring.advanced.trace.logtrace.LogTrace;

import java.lang.reflect.Proxy;

@Configuration
public class DynamicProxyFilterConfig {

    private static final String[] PATTERNS = {"request*", "order*", "save*"};

    @Bean
    public OrderControllerV1 orderControllerV1(LogTrace logTrace){
        OrderControllerV1 orderControllerV1 = new OrderControllerV1(orderServiceV1((logTrace)));


        OrderControllerV1 proxy = (OrderControllerV1) Proxy.newProxyInstance(OrderControllerV1.class.getClassLoader(),
                new Class[]{OrderControllerV1.class}, new LogTraceFilterHandler(orderControllerV1,logTrace,PATTERNS));


        return proxy;
    }

    @Bean
    public OrderServiceV1 orderServiceV1(LogTrace logTrace){
        OrderServiceV1 orderRepositoryV1 = new OrderRepositoryV1Impl(orderRepositoryV1(logTrace));

        OrderServiceV1 proxy = (OrderServiceV1) Proxy.newProxyInstance(OrderServiceV1.class.getClassLoader(),
                new Class[]{OrderRepositoryV1.class}, new LogTraceFilterHandler(orderRepositoryV1,logTrace,PATTERNS));

        return proxy;
    }


    @Bean
    public OrderRepositoryV1 orderRepositoryV1(LogTrace trace){
        OrderRepositoryV1 orderRepositoryV1 = new OrderRepositoryV1(trace);

        OrderRespositoryV1 proxy = Proxy.newProxyInstance(OrderRepositoryV1.claas.getClassLoader(),
                    new Class[]{OrderRepositoryV1.class},new LogTraceFilterHandler(orderRepositoryV1,LogTrace,PATTERNS)
                );

        return proxy;

    }
}
