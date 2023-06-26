package spring.advanced.app.v5;

import org.springframework.stereotype.Repository;
import spring.advanced.trace.callback.TraceTemplate;
import spring.advanced.trace.logtrace.LogTrace;

@Repository
public class OrderRepositoryV5 {

    private final TraceTemplate template;

    public OrderRepositoryV5(LogTrace logTrace) {
        this.template = new TraceTemplate(logTrace);
    }

    public void save(String itemId) throws InterruptedException {
        template.execute("OrderRepositoryV5.request", ()->{
            if(itemId.equals("ex")){
                throw new IllegalStateException("예외");
            }
            sleep(1000);
            return null;
        });
    }

    private void sleep(int millits){
        try{
            Thread.sleep(millits);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
