package org.core.homework.hw11.service;

import org.core.homework.hw11.exception.EntityNotFoundException;
import org.core.homework.hw11.exception.InvalidDateException;
import org.core.homework.hw11.model.Product;
import org.core.homework.hw11.repository.ProductRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(String name, String dateStr) {
        LocalDate date = null;
        try {
            date = LocalDate.parse(dateStr.trim(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            throw new InvalidDateException("Неверный формат даты: '" + dateStr + "'. Ожидается дд.мм.гггг.");
        }

        Product product = new Product(0, name, date);
        productRepository.addProduct(product);
        productRepository.saveFile();
    }

    public boolean deleteProduct(int id) {
        try {
            productRepository.removeById(id);
            productRepository.saveFile();
            return true;
        } catch (EntityNotFoundException e) {
            return false;
        }
    }

}