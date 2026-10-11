package org.core.homework.hw3.main;

import org.core.homework.hw3.cat.Cat;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int count = 0;
        while (count < 10) {
            Cat defaultCat = new Cat();
            System.out.println("Котик " + count + " " +defaultCat);
            count++;
        }
        System.out.println("-----------------------------");

        for (int i = 0; i < 10; i++) {
            Cat defaultCat = new Cat();
            defaultCat.setName("Барсик");
            defaultCat.setAge(1);
            System.out.println("Котяря: " + defaultCat.getName() + " возрастом " + defaultCat.getAge() + " год/лет");
        }
        System.out.println("-----------------------------");

        int count2 = 0;
        do {
            Cat cat = new Cat("Гарфилд", 2);
            System.out.println("Кися: " + cat.getName() + " возрастом " + cat.getAge());
            count2++;
        } while (count2 < 10);
        System.out.println("-----------------------------");

        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Мур", 3);
        cats[1] = new Cat("Себастин", 4);
        cats[2] = new Cat("Чёрныш", 5);
        cats[3] = new Cat("Клёпыч", 2);
        cats[4] = new Cat("Феникс", 10);
        for (Cat cat : cats) {
            System.out.println("Кот: " + cat.getName() + " возрастом " + cat.getAge());
        }
        System.out.println("-----------------------------");

        System.out.println("Подкидыш: " + generateRandomNameCat(random));
        System.out.println("Возраст подкидыша: " + generateRandomAgeCat(random));
    }

    private static String generateRandomNameCat(Random random) {
        String letters = "abcdefghijklmnopqrstuvwxyz";
        int length = 5;
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            stringBuilder.append(letters.charAt(random.nextInt(letters.length())));
        }
        return stringBuilder.toString();
    }

    private static int generateRandomAgeCat(Random random) {
        int age = random.nextInt(1, 29); //с java 17 можно так
        return age;
    }
}

