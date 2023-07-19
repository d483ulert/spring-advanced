package spring.advanced.app.proxy.service.v2;


import spring.advanced.app.proxy.repository.v2.OrderRepositoryV2;
import spring.advanced.app.proxy.service.v1.OrderServiceV1;

public class OrderServiceV2 implements OrderServiceV1 {

    private final OrderRepositoryV2 orderRepositoryV2;

    public OrderServiceV2(OrderRepositoryV2 orderRepositoryV2) {
        this.orderRepositoryV2 = orderRepositoryV2;
    }

    public void orderItem(String itemId) {
        orderRepositoryV2.save(itemId);
    }


}
