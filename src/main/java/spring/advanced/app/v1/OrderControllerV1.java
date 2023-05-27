package spring.advanced.app.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.advanced.trace.TraceStatus;
import spring.advanced.trace.hellotrace.HelloTraceV1;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {

    private final OrderServiecV1 orderServiec;
    private final HelloTraceV1 traceV1;

    @GetMapping("/v1/request")
    public ResponseEntity request(String itemId) throws InterruptedException {
        TraceStatus status =null;

        try{
             status = traceV1.begin("OrderController.request");
            orderServiec.orderItem(itemId);
            traceV1.end(status);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            traceV1.exception(status,e);
            throw e;
        }
    }
}
