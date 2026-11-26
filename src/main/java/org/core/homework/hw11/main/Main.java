package org.core.homework.hw11.main;

import org.core.homework.hw11.repository.OrderRepository;
import org.core.homework.hw11.repository.ProductRepository;
import org.core.homework.hw11.service.OrderService;
import org.core.homework.hw11.service.ProductService;
import org.core.homework.hw11.ui.ConsoleMenu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ProductRepository productRepository = new ProductRepository();
        productRepository.loadFile();

        OrderRepository orderRepository = new OrderRepository(productRepository);
        orderRepository.loadFile();

        ProductService productService = new ProductService(productRepository);
        OrderService orderService = new OrderService(orderRepository, productRepository);

        ConsoleMenu menu = new ConsoleMenu(productService, orderService, productRepository, orderRepository, scanner);
        menu.start();
    }

}