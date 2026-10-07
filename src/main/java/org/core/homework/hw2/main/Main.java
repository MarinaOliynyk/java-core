package org.core.homework.hw2.main;

import org.core.homework.hw2.rainbow.Rainbow;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //задание номера через ввод пользователем в консоле
        System.out.print("Введите номер цвета (например '1'): ");
        int number = scanner.nextInt();
        Rainbow.printColor(number);
        System.out.print("Введите номер цвета (например '3'): ");
        int number2 = scanner.nextInt();
        Rainbow.printColor(number2);
        System.out.print("Введите номер цвета (например '7'): ");
        int number3 = scanner.nextInt();
        Rainbow.printColor(number3);
        System.out.print("Введите номер цвета (например '99'): ");
        int number4 = scanner.nextInt();
        Rainbow.printColor(number4);
        System.out.print("Введите номер цвета (например '101'): ");
        int number5 = scanner.nextInt();
        Rainbow.printColor(number5);
        System.out.println("Спасибо за участие!");
    }
}
