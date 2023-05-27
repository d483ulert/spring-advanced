package spring.advanced.app.v2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring.advanced.trace.TraceId;
import spring.advanced.trace.TraceStatus;
import spring.advanced.trace.hellotrace.HelloTraceV2;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

    private final HelloTraceV2 traceV2;

    public void save(TraceId traceId, String itemId) throws InterruptedException {
        TraceStatus status = null;

        try{
            status = traceV2.beginSync(traceId,"OrderRepositoryV1.request");

            if(itemId.equals("ex")){
                throw new IllegalStateException("예외발생");
            }
            sleep(1000);

            traceV2.end(status);
        }catch (Exception e){
            traceV2.exception(status,e);
            throw e;
        }
    }

    private void sleep(int millits){
        try{
            Thread.sleep(millits);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
