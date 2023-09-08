package spring.advanced.jdkdynamic;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {
    /***
     *  리플렉션은 클래스와 메소드의 메타정보를 사용해서 애플리케이션을 동적으로 만들 수 있지만,
     *  리플렉션은 에러가 런타임에 잡히기 때문에
     *  치명적이다!
     */

    @Test
    void reflection0(){
        Hello target = new Hello();

        //공통로직1 시작
        log.info("start");
        String result1 = target.callA();
        log.info("result= {}", result1);
        //공통로직1 종료

        //공통로직2 시작
        log.info("start");
        String result2 = target.callB();
        log.info("result= {}", result2);
        //공통로직2 종료
    }

    @Test
    void reflection1() throws Exception {
        Class classHello = Class.forName("spring.advanced.jdkdynamic.ReflectionTest$Hello");
        System.out.println(classHello);

        Hello target = new Hello();

        //callA 메소드정보
        Method methodCallA = classHello.getMethod("callA");
        Object result1 = methodCallA.invoke(target);
        log.info("result1={}",result1);

        //callB 메소드정보
        Method methodCallB = classHello.getMethod("callB");
        Object result2 = methodCallB.invoke(target);
        log.info("result2={}",result2);

    }

    @Test
    void relection2() throws Exception {
        Class classHello = Class.forName("spring.advanced.jdkdynamic.ReflectionTest$Hello");
        System.out.println(classHello);

        Hello target = new Hello();

        //callA 메소드정보
        Method methodCallA = classHello.getMethod("callA");
        dynamicCall(methodCallA, target);

        //callB 메소드정보
        Method methodCallB = classHello.getMethod("callB");
        dynamicCall(methodCallB, target);
    }

    private void dynamicCall(Method method, Object target) throws Exception {
        //공통로직1 시작
        log.info("start");
        Object result = method.invoke(target);
        log.info("result= {}", result);
        //공통로직1 종료
    }

    @Slf4j
    static class Hello{
        public String callA(){
            log.info("CallA");
            return "A";
        }

        public String callB(){
            log.info("CallB");
            return "B";
        }

    }
}
