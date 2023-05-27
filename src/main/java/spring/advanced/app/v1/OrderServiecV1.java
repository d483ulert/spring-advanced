package spring.advanced.app.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import spring.advanced.trace.TraceStatus;
import spring.advanced.trace.hellotrace.HelloTraceV1;

@Service
@RequiredArgsConstructor
public class OrderServiecV1 {

    private final OrderRepositoryV1 orderRepository;
    private final HelloTraceV1 traceV1;

    public void orderItem(String itemId) throws InterruptedException {
        TraceStatus status = null;

        try{
            status = traceV1.begin("OrderService.request");
            orderRepository.save(itemId);
            traceV1.end(status);
        }catch (Exception e){
            traceV1.exception(status,e);
            throw e;
        }
    }

}

