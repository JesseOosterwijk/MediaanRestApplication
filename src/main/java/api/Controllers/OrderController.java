package api.Controllers;

import api.Models.OrderModel;
import api.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity GetOrderFromIPad(@Valid @RequestBody OrderModel orderModel) {
        return ResponseEntity.ok(orderModel);
    }

}
