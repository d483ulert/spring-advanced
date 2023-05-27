package spring.advanced.app.v2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.advanced.trace.TraceId;
import spring.advanced.trace.TraceStatus;
import spring.advanced.trace.hellotrace.HelloTraceV2;

@Service
@RequiredArgsConstructor
public class OrderServiecV2 {

    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 traceV2;

    public void orderItem(TraceId traceId, String itemId) throws InterruptedException {
        TraceStatus status = null;

        try{
            status = traceV2.beginSync(traceId,"OrderService.request");
            orderRepository.save(traceId,itemId);
            traceV2.end(status);
        }catch (Exception e){
            traceV2.exception(status,e);
            throw e;
        }
    }

}

