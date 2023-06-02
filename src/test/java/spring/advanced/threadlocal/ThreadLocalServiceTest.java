package spring.advanced.threadlocal;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ThreadLocalServiceTest {

    private ThreadLocalFieldService fieldService = new ThreadLocalFieldService();


    @Test
    void field(){
        log.info("main test");
        Runnable userA= () ->{
            fieldService.logic("userA");
        };
        Runnable userB= () ->{
            fieldService.logic("userB");
        };


        Thread threadA = new Thread(userA);
        Thread threadB = new Thread(userB);

        threadA.setName("Thread-A");
        threadB.setName("Thread-B");

        threadA.start();
        sleep(100);    //동시성 발생X
        threadB.start();

        sleep(3000);
        log.info("main exit");
    }


    private void sleep(int mils){
        try {
            Thread.sleep(mils);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
