package spring.advanced.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import spring.advanced.strategy.code.strategy.ContextV1;
import spring.advanced.strategy.code.strategy.Strategy;
import spring.advanced.strategy.code.strategy.StrategyLogic1;
import spring.advanced.strategy.code.strategy.StrategyLogic2;

@Slf4j
public class ContextV1Test {


    @Test
    void 전략패턴V1(){ //인터페이스 사용
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();

        StrategyLogic2 strategyLogic2= new StrategyLogic2();
        ContextV1 contextV2 = new ContextV1(strategyLogic2);
        contextV2.execute();
    }

    @Test
    void 전략패턴V2(){  //추상익명
        Strategy strategy1 = new Strategy(){
            @Override
            public void call() {
                log.info("비즈니스 로직1");
            }
        };

        ContextV1 contextV1 = new ContextV1(strategy1);
        contextV1.execute();

        Strategy strategy2 = new Strategy(){
            @Override
            public void call() {
                log.info("비즈니스 로직2");
            }
        };

        ContextV1 contextV2 = new ContextV1(strategy2);
        contextV2.execute();
    }

    @Test
    void 전략패턴V3(){  //추상익명 직접주입

        ContextV1 contextV1 = new ContextV1(new Strategy(){
            @Override
            public void call() {
                log.info("비즈니스 로직1");
            }
        });

        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(new Strategy(){
            @Override
            public void call() {
                log.info("비즈니스 로직2");
            }
        });
        contextV2.execute();
    }

    @Test
    void 전략패턴V4(){  //람다사용,  람다를 사용하려면 인터페이스에 메소드가 1개만 있어야함

        ContextV1 contextV1 = new ContextV1(() -> log.info("비즈니스 로직1"));
        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(() -> log.info("비즈니스 로직2"));
        contextV2.execute();
    }
}
