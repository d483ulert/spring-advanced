package spring.advanced.config.v1_proxy.interface_proxy;

import lombok.RequiredArgsConstructor;
import spring.advanced.app.proxy.controller.v1.OrderControllerV1;
import spring.advanced.app.proxy.service.v1.OrderServiceV1;
import spring.advanced.trace.TraceStatus;
import spring.advanced.trace.logtrace.LogTrace;

@RequiredArgsConstructor
public class OrderControllerInterfaceProxy implements OrderControllerV1 {

    private final OrderControllerV1 target;
    private final LogTrace logTrace;
    @Override
    public String request(String itemId) {
        TraceStatus status = null;

        try {
            status = logTrace.begin("OrderController.Request()");
            String request = target.request(itemId);
            logTrace.end(status);

            return request;
        } catch (Exception e) {
            logTrace.exception(status,e);
            throw e;
        }
    }

    @Override
    public String noLog() {
        return null;
    }
}
