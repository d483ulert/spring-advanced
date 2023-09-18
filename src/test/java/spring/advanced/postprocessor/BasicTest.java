package spring.advanced.postprocessor;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BasicTest {

    @Slf4j
    static class A {
        public void helloA(){
            log.info("A");
        }
    }

    @Slf4j
    static class B {
        public void helloB(){
            log.info("B");
        }
    }


    @Slf4j
    @Configuration
    static class BasicConfig{
        @Bean(name = "beanA")
        public A a(){
            return new A();
        }
    }

    @Test
    void basicConfig(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BasicConfig.class);

        // A는 Bean으로 등록됨

        A a = applicationContext.getBean("beanA", A.class);

        a.helloA();
    }



}
