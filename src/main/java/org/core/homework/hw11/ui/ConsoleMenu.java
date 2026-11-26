package org.core.homework.hw11.ui;

import org.core.homework.hw11.exception.InvalidDateException;
import org.core.homework.hw11.model.Order;
import org.core.homework.hw11.model.Product;
import org.core.homework.hw11.repository.OrderRepository;
import org.core.homework.hw11.repository.ProductRepository;
import org.core.homework.hw11.service.OrderService;
import org.core.homework.hw11.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {

    public static final String WELCOME_MENU = """
            === ГЛАВНОЕ МЕНЮ ===
            1. Работа с товарами
            2. Работа с заказами
            0. Выход
            Выберите пункт:
            """;
    public static final String PRODUCT_MENU = """
            === ТОВАРЫ ===
            1. Показать все товары
            2. Добавить товар
            3. Удалить товар
            0. Назад в главное меню
            """;
    public static final String ORDER_MENU = """
            === ЗАКАЗЫ ===
            1. Показать все заказы
            2. Добавить заказ
            3. Удалить заказ
            0. Назад в главное меню
            """;

    private final ProductService productService;
    private final OrderService orderService;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final Scanner scanner;

    public ConsoleMenu(ProductService productService, OrderService orderService,
                       ProductRepository productRepository, OrderRepository orderRepository,
                       Scanner scanner) {
        this.productService = productService;
        this.orderService = orderService;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            System.out.print(WELCOME_MENU);
            int choice = readInt();
            switch (choice) {
                case 1 -> productMenu();
                case 2 -> orderMenu();
                case 0 -> {
                    System.out.println("До свидания!");
                    return;
                }
                default -> System.out.println("Неверный ввод. Попробуйте снова.");
            }
        }
    }

    private void productMenu() {
        while (true) {
            System.out.print(PRODUCT_MENU);
            int choice = readInt();
            switch (choice) {
                case 1 -> showAllProducts();
                case 2 -> addProduct();
                case 3 -> deleteProduct();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Неверный ввод. Попробуйте снова.");
            }
        }
    }

    private void orderMenu() {
        while (true) {
            System.out.print(ORDER_MENU);
            int choice = readInt();
            switch (choice) {
                case 1 -> showAllOrders();
                case 2 -> addOrder();
                case 3 -> deleteOrder();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Неверный ввод. Попробуйте снова.");
            }
        }
    }

    private void showAllProducts() {
        if (productRepository.getAllProducts().isEmpty()) {
            System.out.println("Список товаров пуст.");
            return;
        }
        for (Product p : productRepository.getAllProducts()) {
            System.out.println(p);
        }
    }

    private void addProduct() {
        System.out.print("Введите название товара: ");
        String name = scanner.nextLine();

        while (true) {
            System.out.print("Введите дату изготовления (дд.мм.гггг): ");
            String dateStr = scanner.nextLine().trim();
            try {
                productService.createProduct(name, dateStr);
                System.out.println("Товар добавлен.");
                return;
            } catch (InvalidDateException e) {
                System.out.println("Ошибка: " + e.getMessage() + " Попробуйте снова.");
            }
        }
    }

    private void deleteProduct() {
        System.out.print("Введите ID товара для удаления: ");
        int id = readInt();
        if (productService.deleteProduct(id)) {
            System.out.println("Товар удален.");
        } else {
            System.out.println("Товар с таким ID не найден.");
        }
    }

    private void showAllOrders() {
        if (orderRepository.getAllOrders().isEmpty()) {
            System.out.println("Список заказов пуст.");
            return;
        }
        for (Order o : orderRepository.getAllOrders()) {
            System.out.println(o);
        }
    }

    private void addOrder() {
        List<Product> selectedProducts = new ArrayList<>();
        System.out.println("Добавление товаров в заказ. Введите 0 для завершения.");
        while (true) {
            System.out.print("Введите ID товара: ");
            int pId = readInt();
            if (pId == 0) break;

            Product found = productRepository.findById(pId);
            if (found != null) {
                selectedProducts.add(found);
                System.out.println("Товар добавлен в заказ.");
            } else {
                System.out.println("Товар с таким ID не найден.");
            }
        }

        if (selectedProducts.isEmpty()) {
            System.out.println("Заказ не создан, так как нет товаров.");
            return;
        }

        orderService.createOrder(selectedProducts);
        System.out.println("Заказ создан.");
    }

    private void deleteOrder() {
        System.out.print("Введите ID заказа для удаления: ");
        int id = readInt();
        if (orderService.deleteOrder(id)) {
            System.out.println("Заказ удален.");
        } else {
            System.out.println("Заказ с таким ID не найден.");
        }
    }

    private int readInt() {
        while (true) {
            try {
                String line = scanner.nextLine();
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.print("Ошибка ввода. Введите число: ");
            }
        }
    }

}