package org.core.homework.hw11.repository;

import org.core.homework.hw11.exception.EntityNotFoundException;
import org.core.homework.hw11.model.Order;
import org.core.homework.hw11.model.Product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private static final Path ORDER_FILE = Path.of("orders.txt");
    private static final String SEPARATOR = ";";
    private static final String PRODUCTS_SEPARATOR = ",";

    private final ProductRepository productRepository;

    private List<Order> allOrders = new ArrayList<>();
    private int nextId = 1;

    public OrderRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addOrder(Order order) {
        order.setId(nextId);
        allOrders.add(order);
        nextId++;
    }

    public List<Order> getAllOrders() {
        return allOrders;
    }

    public void saveFile() {
        File file = ORDER_FILE.toFile();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Order order : allOrders) {
                StringBuilder builder = new StringBuilder();
                builder.append(order.getId());
                builder.append(SEPARATOR);

                List<String> ids = new ArrayList<>();
                for (Product product : order.getProducts()) {
                    ids.add(String.valueOf(product.getId()));
                }

                builder.append(String.join(PRODUCTS_SEPARATOR, ids));
                builder.append(SEPARATOR);
                builder.append(order.getOrderDate().toString());
                writer.write(builder.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка записи в файл: " + e.getMessage());
        }
    }

    public void loadFile() {
        File file = ORDER_FILE.toFile();
        if (!file.exists()) {
            return;
        }
        allOrders.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.trim().split(SEPARATOR, -1);
                int id = Integer.parseInt(parts[0]);
                String productsPart = parts[1];
                LocalDate orderDate = LocalDate.parse(parts[2]);

                List<Product> products = new ArrayList<>();

                if (!productsPart.trim().isEmpty()) {
                    String[] productIds = productsPart.split(PRODUCTS_SEPARATOR);
                    for (String pIdStr : productIds) {
                        int pId = Integer.parseInt(pIdStr);
                        Product product = productRepository.findById(pId);
                        if (product != null) {
                            products.add(product);
                        }
                    }
                }

                Order order = new Order(id, products, orderDate);
                allOrders.add(order);
            }
        } catch (IOException | RuntimeException e) {
            throw new RuntimeException("Ошибка чтения файла: " + e.getMessage());
        }
        updateNextId();
    }

    public void removeById(int id) {
        Order order = null;
        for (Order o : allOrders) {
            if (o.getId() == id) {
                order = o;
                break;
            }
        }
        if (order == null) {
            throw new EntityNotFoundException("Заказ с id=" + id + " не найден.");
        }
        allOrders.remove(order);
    }

    private void updateNextId() {
        int maxId = 0;
        for (Order order : allOrders) {
            if (order.getId() > maxId) {
                maxId = order.getId();
            }
        }
        nextId = maxId + 1;
    }

}