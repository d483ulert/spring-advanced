package spring.advanced.app.v3;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.advanced.trace.TraceStatus;
import spring.advanced.trace.hellotrace.HelloTraceV2;
import spring.advanced.trace.logtrace.LogTrace;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {

    private final OrderServiecV3 orderServiec;
    private final LogTrace logTrace;

    @GetMapping("/v3/request")
    public ResponseEntity request(String itemId) throws InterruptedException {
        TraceStatus status =null;

        try{
             status = logTrace.begin("OrderController.request");
            orderServiec.orderItem(status.getTraceId(),itemId);
            logTrace.end(status);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            logTrace.exception(status,e);
            throw e;
        }
    }
}
