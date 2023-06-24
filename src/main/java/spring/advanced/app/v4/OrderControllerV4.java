package spring.advanced.app.v4;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.advanced.trace.logtrace.LogTrace;
import spring.advanced.trace.template.AbstractTemplate;

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {

    private final OrderServiceV4 orderService;
    private final LogTrace logTrace;

    @GetMapping("/v4/request")
    public String request(String itemId) throws InterruptedException {
        AbstractTemplate<String> template = new AbstractTemplate<String>(logTrace) {
            @Override
            protected String call() throws InterruptedException {
                orderService.orderItem(itemId);
                return "ok";
            }
        };
       return template.execute("OrderController.request");
    }
}
