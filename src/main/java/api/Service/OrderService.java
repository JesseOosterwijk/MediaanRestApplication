package api.Service;

import api.Entities.Order;
import api.DAL.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    private OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<Order> getOrderedFood(UUID id) {
        return orderRepository.findOrderById(id);
    }
}
