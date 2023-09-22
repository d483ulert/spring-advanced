package spring.advanced.config.v5_autoproxy;


import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.advanced.trace.logtrace.LogTrace;

@Configuration
public class AutoProxyConfig {


    @Bean
    public Advisor advisor(LogTrace logTrace){

        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* spring.advanced.app..*(..)) &&!execution(* spring.advanced.app..*(..))");


        LogTraceAdvisor advisor = new LogTraceAdviosr(logTrace);

        return new DefaultPointcutAdvisor((pointcut, advisor));

    }

    //프록시는 1개,  advisor가 여러개 생성됨.
}
