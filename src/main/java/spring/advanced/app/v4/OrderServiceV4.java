package spring.advanced.app.v4;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.advanced.trace.TraceStatus;
import spring.advanced.trace.logtrace.LogTrace;
import spring.advanced.trace.template.AbstractTemplate;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {

    private final OrderRepositoryV4 orderRepository;
    private final LogTrace logTrace;

    public void orderItem(String itemId) throws InterruptedException {
        TraceStatus status = null;

        AbstractTemplate<Void> template = new AbstractTemplate<>(logTrace) {
            @Override
            protected Void call() throws InterruptedException {
                orderRepository.save(itemId);
                return null;
            }
        };
         template.execute("OrderService.request");
    }
}

