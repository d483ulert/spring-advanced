package spring.advanced.pureproxy.proxy.code;

import org.junit.jupiter.api.Test;

public class ProxyPatternTest {


    @Test
    void noProxyTest(){
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);

        client.excute();
        client.excute();
        client.excute();
    }
}
