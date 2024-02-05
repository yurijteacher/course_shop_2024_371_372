package ua.com.kisit2024.course_shop_2024_371_372.service;

import org.springframework.stereotype.Service;
import ua.com.kisit2024.course_shop_2024_371_372.entity.Order;
import ua.com.kisit2024.course_shop_2024_371_372.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveNewOrderForClient(Order order){
        return orderRepository.save(order);
    }



}
