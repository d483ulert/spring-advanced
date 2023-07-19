package spring.advanced.app.proxy.v1.controller.v1;

import spring.advanced.app.proxy.v1.service.v1.OrderServiceV1;

public class OrderControllerV1Impl implements OrderControllerV1{
    private final OrderServiceV1 orderServiceV1;

    public OrderControllerV1Impl(OrderServiceV1 orderServiceV1) {
        this.orderServiceV1 = orderServiceV1;
    }

    @Override
    public String request(String itemId) {
        orderServiceV1.orderItem(itemId);
        return "ok";
    }

    @Override
    public String noLog() {
        return "ok";
    }
}
