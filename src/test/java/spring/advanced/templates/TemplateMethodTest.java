package spring.advanced.templates;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import spring.advanced.templates.code.AbstractTemplate;
import spring.advanced.templates.code.SubClassLogic1;
import spring.advanced.templates.code.SubClassLogic2;

@Slf4j
@SpringBootTest
public class TemplateMethodTest {


    @Test
    void 템플릿메소드V0(){
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        log.info("비즈니스 로직1 실행");

        long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;

        log.info("resultTime:{} "+ resultTime);
    }

    private void logic2(){
        long startTime = System.currentTimeMillis();
        log.info("비즈니스 로직2 실행");
        long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;

        log.info("resultTime:{} "+ resultTime);
    }

    /**
     *  템플릿 메서드 패턴 적용
     */
    @Test
    void 템플릿메소드V1(){ //템플릿 메소드 적용
        AbstractTemplate template1 = new SubClassLogic1();
        template1.execute();

        AbstractTemplate template2 = new SubClassLogic2();
        template2.execute();
    }

    /**
     *  템플릿 메서드 패턴 적용
     */
    @Test
    void 템플릿메소드V2(){
        AbstractTemplate template1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직1 실행");
            }
        };
        template1.execute();

        AbstractTemplate template2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직2 실행");
            }
        };
        template2.execute();
    }


}
