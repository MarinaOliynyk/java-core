package org.core.homework.hw11.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.core.homework.hw11.exception.EntityNotFoundException;
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

@Getter
@Setter
@NoArgsConstructor
public class ProductRepository {

    private static final Path PRODUCT_FILE = Path.of("products.txt");
    private static final String SEPARATOR = ";";

    private List<Product> allProducts = new ArrayList<>();
    private int nextId = 1;

    public void addProduct(Product product) {
        product.setId(nextId);
        allProducts.add(product);
        nextId++;
    }

    public List<Product> getAllProducts() {
        return allProducts;
    }

    public void saveFile() {
        File file = PRODUCT_FILE.toFile();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Product product : allProducts) {
                StringBuilder builder = new StringBuilder();
                builder.append(product.getId());
                builder.append(SEPARATOR);
                builder.append(product.getName());
                builder.append(SEPARATOR);
                builder.append(product.getManufactureDate());
                writer.write(builder.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка записи в файл " + PRODUCT_FILE, e);
        }
    }

    public void loadFile() {
        File file = PRODUCT_FILE.toFile();
        if (!file.exists()) {
            return;
        }

        allProducts.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.trim().split(SEPARATOR);
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                LocalDate manufactureDate = LocalDate.parse(parts[2]);

                Product product = new Product(id, name, manufactureDate);
                allProducts.add(product);
            }
        } catch (IOException | RuntimeException e) {
            throw new RuntimeException("Ошибка чтения файла " + PRODUCT_FILE, e);
        }
        updateNextId();
    }

    public Product findById(int id) {
        for (Product product : allProducts) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new EntityNotFoundException("Товар " + id + " не найден.");
        }
        allProducts.remove(findById(id));
    }

    private void updateNextId() {
        int maxId = 0;
        for (Product product : allProducts) {
            if (product.getId() > maxId) {
                maxId = product.getId();
            }
        }
        nextId = maxId + 1;
    }

}