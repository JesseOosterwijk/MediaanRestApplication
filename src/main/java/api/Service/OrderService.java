package api.Service;

import api.Entities.Order;
import api.DAL.OrderRepository;
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
