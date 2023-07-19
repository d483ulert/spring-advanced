package spring.advanced.app.proxy.service.v3;

import org.springframework.stereotype.Service;
import spring.advanced.app.proxy.repository.v3.OrderRepositoryV3;
import spring.advanced.app.proxy.service.v1.OrderServiceV1;

@Service
public class OrderServiceV3 implements OrderServiceV1 {

    private final OrderRepositoryV3 orderRepositoryV3;

    public OrderServiceV3(OrderRepositoryV3 orderRepositoryV3) {
        this.orderRepositoryV3 = orderRepositoryV3;
    }

    public void orderItem(String itemId) {
        orderRepositoryV3.save(itemId);
    }


}
