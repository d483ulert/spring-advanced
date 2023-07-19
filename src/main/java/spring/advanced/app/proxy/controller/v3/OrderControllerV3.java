package spring.advanced.app.proxy.controller.v3;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import spring.advanced.app.proxy.service.v2.OrderServiceV2;
import spring.advanced.app.proxy.service.v3.OrderServiceV3;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {

    private final OrderServiceV3 orderServiceV3;

    @GetMapping("/proxy/v3/request")
    public String request(String itemId) {
        orderServiceV3.orderItem(itemId);
        return "ok";
    }

    @GetMapping("/proxy/v3/no-log")
    public String noLog() {
        return "ok";
    }
}
