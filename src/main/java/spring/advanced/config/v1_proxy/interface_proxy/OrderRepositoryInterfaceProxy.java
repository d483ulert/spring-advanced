package spring.advanced.config.v1_proxy.interface_proxy;


import lombok.RequiredArgsConstructor;
import spring.advanced.app.proxy.repository.v1.OrderRespositoryV1;
import spring.advanced.app.v1.OrderRepositoryV1;
import spring.advanced.trace.TraceStatus;
import spring.advanced.trace.logtrace.LogTrace;

@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements OrderRespositoryV1 {


    private final OrderRespositoryV1 target;
    private final LogTrace logTrace;


    @Override
    public void save(String itemId) {

        TraceStatus status = null;

        try {
            status = logTrace.begin("OrderRepository.request()");
            target.save(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status,e);
        }
    }
}
