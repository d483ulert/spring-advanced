package spring.advanced.trace.callback;

import lombok.RequiredArgsConstructor;
import spring.advanced.trace.TraceStatus;
import spring.advanced.trace.logtrace.LogTrace;

@RequiredArgsConstructor
public class TraceTemplate {

    private final LogTrace logTrace;

    public <T> T execute(String message,TraceCallback<T> callback) throws InterruptedException {

        TraceStatus status = null;

        try{
            status = logTrace.begin(message);
            T result =callback.call();

            logTrace.end(status);
            return result;
        }catch (Exception e){
            logTrace.exception(status,e);
            throw e;
        }
    }

}
