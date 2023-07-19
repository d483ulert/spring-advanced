package spring.advanced.app.proxy.service.v1;


import spring.advanced.app.proxy.repository.v1.OrderRespositoryV1;

public class OrderServiceV1Impl implements OrderServiceV1{

    private final OrderRespositoryV1 orderRespositoryV1;

    public OrderServiceV1Impl(OrderRespositoryV1 orderRespositoryV1) {
        this.orderRespositoryV1 = orderRespositoryV1;
    }

    @Override
    public void orderItem(String itemId) {
        orderRespositoryV1.save(itemId);
    }


}
