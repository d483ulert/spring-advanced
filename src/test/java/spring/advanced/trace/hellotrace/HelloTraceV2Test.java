package spring.advanced.trace.hellotrace;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import spring.advanced.trace.TraceStatus;

@SpringBootTest
class HelloTraceV2Test {
    //ctrl shift T


    @Test
    void begin_end(){
        HelloTraceV2 traceV2 = new HelloTraceV2();
        TraceStatus status = traceV2.begin("h2");
        TraceStatus status2 = traceV2.beginSync(status.getTraceId(),"h2");
        traceV2.end(status2);
        traceV2.end(status);
    }

    @Test
    void begin_exception(){
        HelloTraceV2 traceV2 = new HelloTraceV2();
        TraceStatus status = traceV2.begin("hi");
        TraceStatus status2 = traceV2.beginSync(status.getTraceId(),"hi");
        traceV2.exception(status2,new IllegalAccessException());
        traceV2.exception(status,new IllegalAccessException());
    }

}