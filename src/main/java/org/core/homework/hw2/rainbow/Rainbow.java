package org.core.homework.hw2.rainbow;

public class Rainbow {

    public static final int RED = 1;
    public static final int ORANGE = 2;
    public static final int YELLOW = 3;
    public static final int GREEN = 4;
    public static final int LIGHT_BLUE = 5;
    public static final int BLUE = 6;
    public static final int VIOLET = 7;
    public static final int YELLOW_GREEN = 101; //жёлто-зелёный
    public static final int BLUE_GREEN = 102; //сине-зелёный
    public static final int RED_ORANGE = 103; //красно-оранжевый

    public static void printColor(int number) {
        if (number <= VIOLET && number >= RED) {
            printPrimaryColor(number);
        } else if (number >= YELLOW_GREEN && number <= RED_ORANGE) {
            printMixedColor(number);
        } else {
            System.out.println("Цвет с номером " + number + " не найден.");
        }
    }

    public static void printPrimaryColor(int number) {
        switch (number) {
            case 1:
                System.out.println("Красный");
                break;
            case 2:
                System.out.println("Оранжевый");
                break;
            case 3:
                System.out.println("Жёлтый");
                break;
            case 4:
                System.out.println("Зелёный");
                break;
            case 5:
                System.out.println("Голубой");
                break;
            case 6:
                System.out.println("Синий");
                break;
            case 7:
                System.out.println("Фиолетовый");
                break;
            default:
                System.out.println("Основной цвет под номером " + number + " не существует");
                break;
        }
    }

    public static void printMixedColor(int number) {
        switch (number) {
            case 101:
                System.out.println("Жёлто-зелёный");
                break;
            case 102:
                System.out.println("Сине-зелёный");
                break;
            case 103:
                System.out.println("Красно-оранжевый");
                break;
            default:
                System.out.println("Полуцвет под номером " + number + " не существует");

        }
    }
}
