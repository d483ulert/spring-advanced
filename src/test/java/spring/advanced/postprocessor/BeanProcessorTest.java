package spring.advanced.postprocessor;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanProcessorTest {

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
    static class BeanPostProcessorConf{
        @Bean(name = "beanA")
        public A a(){
            return new A();
        }

        @Bean
        public AToB atob(){
            return new AToB();
        }
    }

    @Slf4j
    static class AToB implements BeanPostProcessor{

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            log.info("beanName= {}", beanName,bean);
            if(bean instanceof  A){
                return new B();
            }

            return bean;
        }
    }

    @Test
    void basicConfig(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanPostProcessorConf.class);

        // A는 Bean으로 등록됨

        B b = applicationContext.getBean("beanA", B.class);

        b.helloB();
    }



}
