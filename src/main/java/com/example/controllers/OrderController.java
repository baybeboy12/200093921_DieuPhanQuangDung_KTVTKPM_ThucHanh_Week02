package com.example.controllers;

import com.example.models.Order;
import com.example.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @GetMapping("/orders")
    List<Order> getAllOrder(){
        return orderRepository.findAll();
    }
    @GetMapping("/orders/{id}")
    Order getOrderById(@PathVariable("id") long id){
        Optional<Order> op = orderRepository.findById(id);
        return op.get();
    }
}
