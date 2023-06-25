package spring.advanced.strategy.code.template;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class TemplateCallbackTest {


    /**
     * 템플릿 콜백 패턴 -익명 내부 클래스
     * 
     */
    @Test
    void callbackV1(){
        TimeLogTemplate template1 = new TimeLogTemplate();
        template1.execute(new Callback() {
            @Override
            public void call() {
                log.info("로직1");
            }
        });
        template1.execute(new Callback() {
            @Override
            public void call() {
                log.info("로직2");
            }
        });
    }

    @Test
    void callbackV2(){
        TimeLogTemplate template1 = new TimeLogTemplate();
        template1.execute(() -> log.info("로직1"));
        template1.execute(() -> log.info("로직2"));
    }
    
}
