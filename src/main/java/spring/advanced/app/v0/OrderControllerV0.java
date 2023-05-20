package spring.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV0 {

    private final OrderServiecV0 orderServiec;

    @GetMapping("/v0/request")
    public ResponseEntity request(String itemId) throws InterruptedException {
        orderServiec.orderItem(itemId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
