package spring.advanced.app.proxy.v1.service.v2;


import spring.advanced.app.proxy.v1.repository.v2.OrderRespositoryV2;
import spring.advanced.app.proxy.v1.service.v1.OrderServiceV1;

public class OrderServiceV2 implements OrderServiceV1 {

    private final OrderRespositoryV2 orderRespositoryV2;

    public OrderServiceV2(OrderRespositoryV2 orderRespositoryV2) {
        this.orderRespositoryV2 = orderRespositoryV2;
    }

    public void orderItem(String itemId) {
        orderRespositoryV2.save(itemId);
    }


}
