package spring.advanced.config.v1_proxy.concrete_proxy;

import spring.advanced.app.v2.OrderRepositoryV2;
import spring.advanced.trace.TraceStatus;
import spring.advanced.trace.logtrace.LogTrace;

public class OrderRepositoryConcreteProxy extends OrderRepositoryV2 {

    private final OrderRepositoryV2 target;
    private final LogTrace trace;

    public OrderRepositoryConcreteProxy(OrderRepositoryV2 orderRepositoryV2, LogTrace logTrace){
        super(null);
        this.target = orderRepositoryV2;
        this.trace = logTrace;
    }



    @Override
    public void save(String itemId){
        TraceStatus status = null;

        try {
            status = trace.begin("OrderRepository.request()");
            target.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status,e);
        }
    }
}
