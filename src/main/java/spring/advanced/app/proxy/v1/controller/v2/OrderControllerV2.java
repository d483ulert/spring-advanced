package spring.advanced.app.proxy.v1.controller.v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.advanced.app.proxy.v1.service.v2.OrderServiceV2;

@Slf4j
@RequestMapping
@ResponseBody
public class OrderControllerV2  {
    private final OrderServiceV2 orderServiceV2;

    public OrderControllerV2(OrderServiceV2 orderServiceV2) {
        this.orderServiceV2 = orderServiceV2;
    }

    @GetMapping("/proxy/v2/request")
    public String request(String itemId) {
        orderServiceV2.orderItem(itemId);
        return "ok";
    }

    @GetMapping("/proxy/v2/no-log")
    public String noLog() {
        return "ok";
    }
}
