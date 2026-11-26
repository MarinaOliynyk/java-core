package org.core.homework.hw11.service;

import org.core.homework.hw11.exception.EntityNotFoundException;
import org.core.homework.hw11.model.Order;
import org.core.homework.hw11.model.Product;
import org.core.homework.hw11.repository.OrderRepository;
import org.core.homework.hw11.repository.ProductRepository;

import java.time.LocalDate;
import java.util.List;

public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public void createOrder(List<Product> products) {
        Order order = new Order(0, products, LocalDate.now());
        orderRepository.addOrder(order);
        orderRepository.saveFile();
    }

    public boolean deleteOrder(int id) {
        try {
            orderRepository.removeById(id);
            orderRepository.saveFile();
            return true;
        } catch (EntityNotFoundException e) {
            return false;
        }
    }

}