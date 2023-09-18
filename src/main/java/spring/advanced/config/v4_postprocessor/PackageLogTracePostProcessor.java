package spring.advanced.config.v4_postprocessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

@Slf4j
public class PackageLogTracePostProcessor implements BeanPostProcessor {


    private final String basePkg;
    private final Advisor advisor;


    public PackageLogTracePostProcessor(String basePkg, Advisor advisor) {
        this.basePkg = basePkg;
        this.advisor = advisor;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("param beanName ={} bean ={}", beanName, bean.getClass());
    /*
        프록시 적용 대상 여부 체크
        프록시 적용 대상이 아니면 원본을 그대로 진행
    */
        String pkgName = bean.getClass().getPackageName();

        if(!pkgName.startsWith(basePkg)){
            return bean;
        }

        //프로시 대상이면 프록시만들어서 반환
        ProxyFactory factory = new ProxyFactory(bean);
        factory.addAdvisor(advisor);

        Object proxy = factory.getProxy();

        log.info("create proxy: target ={} proxy ={}", bean.getClass(), proxy.getClass());


        return proxy;

    }
}
