package spring.advanced.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator implements Component{

    private Component component;

    public MessageDecorator(Component component){
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("Message Decorator 실행");
        String result = component.operation();
        return "****"+result+"****";
    }
}
