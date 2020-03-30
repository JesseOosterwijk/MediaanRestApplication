package REST.Service;

import REST.Entities.Order;
import REST.Repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    private OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public ArrayList<Order> getOrderedFood() {
        return new ArrayList<Order>();
    }
}
