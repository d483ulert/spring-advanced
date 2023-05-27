package spring.advanced.app.v2;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.advanced.trace.TraceStatus;
import spring.advanced.trace.hellotrace.HelloTraceV2;

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {

    private final OrderServiecV2 orderServiec;
    private final HelloTraceV2 traceV2;

    @GetMapping("/v2/request")
    public ResponseEntity request(String itemId) throws InterruptedException {
        TraceStatus status =null;

        try{
             status = traceV2.begin("OrderController.request");
            orderServiec.orderItem(status.getTraceId(),itemId);
            traceV2.end(status);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            traceV2.exception(status,e);
            throw e;
        }
    }
}
