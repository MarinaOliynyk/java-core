package org.core.homework.hw5.main;

import org.core.homework.hw5.phone.Phone;

public class Main {

    public static void main(String[] args) {
        Phone ph1 = new Phone();
        Phone ph2 = new Phone();
        Phone ph3 = new Phone();

        System.out.println("Номер: " + ph1.getNumber() + " " + "Модель телефона: " + ph1.getModel() + " " + "Вес: " + ph1.getWeight());
        System.out.println("Номер: " + ph2.getNumber() + " " + "Модель телефона: " + ph2.getModel() + " " + "Вес: " + ph2.getWeight());
        System.out.println("Номер: " + ph3.getNumber() + " " + "Модель телефона: " + ph3.getModel() + " " + "Вес: " + ph3.getWeight());

        ph1.receiveCall("Мама");
        ph2.receiveCall("Матоша");
        ph3.receiveCall("Андрей");

        System.out.println("Номер телефона: " + ph1.getNumber());
        System.out.println("Номер телефона: " + ph2.getNumber());
        System.out.println("Номер телефона: " + ph3.getNumber());

        ph1.receiveCall("Мама", "+79171699999");
        ph2.receiveCall("Матоша", "+79675556666");
        ph3.receiveCall("Андрей", "+79376506363");

        ph1.sendMessage("+79171699999");
        ph2.sendMessage("+79675556666");
        ph3.sendMessage("+79376506363");
    }
}