package spring.advanced.templates.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {

    public void execute(){
        long startTime = System.currentTimeMillis();
        //비즈니스로직 실행
        call();
        //비즈니스로직 종료
        long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;

        log.info("resultTime:{} "+ resultTime);
    }

    protected abstract void call();//변하는 부분을 자식클래스를 만들어서 처리
}

