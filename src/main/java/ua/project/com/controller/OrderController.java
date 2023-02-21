package ua.project.com.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.project.com.mapper.OrderMapper;
import ua.project.com.modelDTO.OrderDTO;
import ua.project.com.service.ComputerService;
import ua.project.com.service.OrderService;

@RestController
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;

    private final OrderMapper orderMapper;
    private final ComputerService computerService;

    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable Long id){
        return orderMapper.toDTO(orderService.getOrderById(id));
    }
    @PostMapping("/create")
    public OrderDTO createNewOrder(@RequestBody String name){
        return orderMapper.toDTO(orderService.createNewOrder(name));
    }
    @PatchMapping("update/{id}")
    public void updateOrder (@PathVariable Long id,
                               @RequestBody String name,
                               @RequestBody Long computerId) {
        orderService.updateOrder(id, name,
                computerService.getComputerById(computerId));
    }
}
