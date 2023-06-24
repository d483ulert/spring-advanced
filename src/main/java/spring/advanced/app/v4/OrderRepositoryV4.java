package spring.advanced.app.v4;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring.advanced.trace.TraceStatus;
import spring.advanced.trace.logtrace.LogTrace;
import spring.advanced.trace.template.AbstractTemplate;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace logTrace;

    public void save(String itemId) throws InterruptedException {
        TraceStatus status = null;
        AbstractTemplate<Void> template = new AbstractTemplate<>(logTrace) {
            @Override
            protected Void call() throws InterruptedException {
                if(itemId.equals("ex")){
                    throw new IllegalStateException("예외발생");
                }
                sleep(1000);
                return null;
            }
        };
        template.execute("OrderRepositoryV4.request");
    }

    private void sleep(int millits){
        try{
            Thread.sleep(millits);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
