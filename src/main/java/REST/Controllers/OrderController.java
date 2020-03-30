package REST.Controllers;

import REST.Entities.Order;
import REST.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/ipad")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orderedfood")
    public ArrayList<Order> GetOrderFromIPad() {
        ArrayList<Order> orderList = orderService.getOrderedFood();
        return orderList;
    }

}
