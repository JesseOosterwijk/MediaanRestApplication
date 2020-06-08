package api.Service;

import api.DAL.OrderRepository;
import api.Entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void SaveOrder(Order order) {
        orderRepository.save(order);
    }

    public void DeleteOrder(Order order) { orderRepository.delete(order);}
}
