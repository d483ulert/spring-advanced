package spring.advanced.app.proxy.repository.v1;

public class OrderRespositoryV1Impl implements OrderRespositoryV1{
    @Override
    public void save(String itemId) {
        //저장로직
        if(itemId.equals("ex")){
            throw new IllegalStateException("예외발생");
        }
        sleep(1000);
    }

    private void sleep(int millis){
        try{
            Thread.sleep(millis);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
