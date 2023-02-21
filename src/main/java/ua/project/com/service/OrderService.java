package ua.project.com.service;


import org.springframework.stereotype.Service;
import ua.project.com.model.Computer;
import ua.project.com.model.Order;
import ua.project.com.repo.OrderRepos;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepos orderRepos;

    public OrderService(OrderRepos orderRepos) {
        this.orderRepos = orderRepos;
    }

    public Order getOrderById(Long orderId) {
        return orderRepos.findById(orderId).get();
    }

    public Order createNewOrder(String name) {
        return orderRepos.save(Order.builder()
                .name(name)
                .build());
    }

    public void updateOrder(Long id, String name, Computer computer) {
        Order order = orderRepos.findById(id).get();
        if(name != null) order.setName(name);
        if(computer != null && !order.getComputerList().contains(computer)){
            order.addComputerInOrder(computer);
        }
        orderRepos.save(order);
    }
}
