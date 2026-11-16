package org.core.homework.hw10.main;

import org.core.homework.hw10.exception.EmptyNicknameException;
import org.core.homework.hw10.exception.HallAlreadyBookedException;
import org.core.homework.hw10.exception.InvalidDancerAgeException;

import java.util.Scanner;

public class Main {

    private static final String BIG_HALL = "Зал Биг на 150 кв.м";
    private static final String ROCKY_HALL = "Зал Рокки на 110 кв.м";

    public static void main(String[] args) {
        Scanner dancer = new Scanner(System.in);

        if (checkRegistrationDancer(dancer)) {
            bookHall();
        }
    }

    private static String registerDancer(String nickName, int age) throws EmptyNicknameException, InvalidDancerAgeException {
        if (nickName == null || nickName.isEmpty())
            throw new EmptyNicknameException("Танцор не в списке или введен неверный никнейм");
        if (age < 16 || age > 55) {
            throw new InvalidDancerAgeException("Доступ на съёмки с указанным возрастом " + age + " запрещен", age);
        }
        return "Танцор " + nickName + " может пройти в зал съёмки.";
    }

    private static boolean checkRegistrationDancer(Scanner dancer) {
        System.out.println("Введи свой возраст");
        int dancerAge = dancer.nextInt();
        dancer.nextLine();
        System.out.println("Введи свой никнейм");
        String nickName = dancer.nextLine();
        try {
            String result = registerDancer(nickName, dancerAge);
            System.out.println(result);
            return true;
        } catch (InvalidDancerAgeException | EmptyNicknameException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            System.out.println("Свяжись с лидером проекта!");
        }
    }


    private static String checkHall(String hallName) throws HallAlreadyBookedException {
        if (BIG_HALL.equals(hallName)) {
            throw new HallAlreadyBookedException("Внимание '" + hallName + "' уже забронирован на 21.11");
        }
        return "Поздравляем '" + hallName + "' успешно забронирован!";
    }

    private static void bookHall() {
        System.out.println("Зал на съемку (бронирование): ");
        choiceHall(BIG_HALL);

        System.out.println("Зал на съемку (бронирование): ");
        choiceHall(ROCKY_HALL);
    }

    private static void choiceHall(String hallName) {
        try {
            System.out.println(checkHall(hallName));
        } catch (HallAlreadyBookedException e) {
            System.out.println(e.getMessage());
        }
    }
}
