package spring.advanced.trace.hellotrace;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import spring.advanced.trace.TraceStatus;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloTraceV1Test {
    //ctrl shift T


    @Test
    void begin_end(){
        HelloTraceV1 traceV1 = new HelloTraceV1();
        TraceStatus status = traceV1.begin("hi");
        traceV1.end(status);
    }

    @Test
    void begin_exception(){
        HelloTraceV1 traceV1 = new HelloTraceV1();
        TraceStatus status = traceV1.begin("hi");
        traceV1.exception(status,new IllegalAccessException());
    }

}