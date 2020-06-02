package api.Controllers;

import api.Entities.Order;
import api.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/ipad")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/orderedfood")
    public ResponseEntity GetOrderFromIPad(@Valid @RequestBody Order order) {
        return ResponseEntity.ok(order);
    }

    @PostMapping("/addorder")
    public ResponseEntity SaveOrder(@Valid @RequestBody Order order){
        try {
            orderService.SaveOrder(order);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

}
