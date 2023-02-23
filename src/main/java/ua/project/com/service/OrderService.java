package ua.project.com.service;


import org.springframework.stereotype.Service;
import ua.project.com.model.Computer;
import ua.project.com.model.Order;
import ua.project.com.repository.OrderRepos;

@Service
public class OrderService {

    private final OrderRepos orderRepository;

    public OrderService(OrderRepos orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).get();
    }

    public Order createNewOrder(String name) {
        return orderRepository.save(Order.builder()
                .name(name)
                .build());
    }

    public void updateOrder(Long id, String name, Computer computer) {
        Order order = orderRepository.findById(id).get();
        if(name != null) order.setName(name);
        if(computer != null && !order.getComputerList().contains(computer)){
            order.addComputerInOrder(computer);
        }
        orderRepository.save(order);
    }
}
