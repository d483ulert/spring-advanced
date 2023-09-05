package spring.advanced.pureproxy.concreate.code;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteLogic {


    public String operation(){
        log.info("ConcreateLogic");

        return "data";

    }
}
