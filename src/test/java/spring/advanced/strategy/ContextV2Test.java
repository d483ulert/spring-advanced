package spring.advanced.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import spring.advanced.strategy.code.strategy.ContextV2;
import spring.advanced.strategy.code.strategy.StrategyLogic1;
import spring.advanced.strategy.code.strategy.StrategyLogic2;

@Slf4j
public class ContextV2Test {
    /**
     * 전략패턴적용
     */
    @Test
    void 전략패턴V1() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new StrategyLogic1());
        contextV2.execute(new StrategyLogic2());

    }

    /**
     * 전략패턴적용 익명 내부 클래스
     */
    @Test
    void 전략패턴V2() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new StrategyLogic1() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        });
        contextV2.execute(new StrategyLogic2() {
            @Override
            public void call() {
                log.info("비즈니스 로직2 실행");
            }
        });
    }

    /**
     * 전략패턴적용 익명 내부 클래스2 람다
     */
    @Test
    void 전략패턴V3() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(() -> log.info("비즈니스 로직1 실행"));
        contextV2.execute(() -> log.info("비즈니스 로직2 실행"));
    }

}
