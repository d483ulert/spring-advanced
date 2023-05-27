package spring.advanced.app.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import spring.advanced.trace.TraceStatus;
import spring.advanced.trace.hellotrace.HelloTraceV1;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {

    private final HelloTraceV1 traceV1;

    public void save(String itemId) throws InterruptedException {
        TraceStatus status = null;

        try{
            status = traceV1.begin("OrderRepositoryV1.request");

            if(itemId.equals("ex")){
                throw new IllegalStateException("예외발생");
            }
            sleep(1000);

            traceV1.end(status);
        }catch (Exception e){
            traceV1.exception(status,e);
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
