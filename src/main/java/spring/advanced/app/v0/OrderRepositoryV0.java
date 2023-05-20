package spring.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV0 {

    public void save(String itemId) throws InterruptedException {
        if(itemId.equals("ex")){
            throw new IllegalStateException("예외발생");
        }
        sleep(1000);
    }

    private void sleep(int millits){
        try{
            Thread.sleep(millits);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
