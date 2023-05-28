package spring.advanced.trace.logtrace;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import spring.advanced.trace.TraceStatus;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FieldLogTraceTest {

    FieldLogTrace trace = new FieldLogTrace();

    @Test
    void begin_end_level2(){
        TraceStatus status1 = trace.begin("hi1");
        TraceStatus status2 = trace.begin("hi2");
        trace.end(status1);
        trace.end(status2);
    }
    @Test
    void begin_exception_level2(){
        TraceStatus status1 = trace.begin("hi1");
        TraceStatus status2 = trace.begin("hi2");
        trace.exception(status1,new IllegalStateException());
        trace.exception(status2,new IllegalStateException());
    }


}