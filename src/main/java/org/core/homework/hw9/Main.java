package org.core.homework.hw9;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MyList<String> list = new MyArrayList<>();
        list.add("Vermouth");
        list.add("Prosecco");
        list.add("Mineral Water");
        System.out.println("В списке: " + list.size() + " ингредиента");
        System.out.println(getFirstElementOrEmpty(list));

        findAndRemove(list, "Mineral Water");
        updateIngredients(list);

        List<String> extra = new ArrayList<>();
        extra.add("Ice");
        extra.add("Orange");
        addExtraIngredients(list, extra);

        printList(list);
    }

    private static String getFirstElementOrEmpty(MyList<String> list) {
        if (list.isEmpty()) {
            return "Список пуст";
        }
        return "Первый ингредиент списка: " + list.get(0);
    }

    private static void findAndRemove(MyList<String> list, String value) {
        if (list.contains(value)) {
            int index = list.indexOf(value);
            System.out.println("Найденный ингредиент '" + list.remove(index) + "' удален с позиции " + index);
        } else {
            System.out.println("Ингредиент '" + value + "' не найден.");
        }
    }

    private static void updateIngredients(MyList<String> list) {
        list.add(1, "Schweppes");
        System.out.println("Добавили в середину списка: " + list.get(1));
        String oldIngredient = list.set(0, "Aperol");
        System.out.println("Заменили " + oldIngredient + " на новый ингредиент: " + list.get(0));
    }

    private static void addExtraIngredients(MyList<String> main, List<String> extra) {
        System.out.println("Добавляем ингредиенты: " + extra);
        main.addAll(extra);
    }

    private static void printList(MyList<String> list) {
        System.out.println("--- Итоговый список ингредиентов ---");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}