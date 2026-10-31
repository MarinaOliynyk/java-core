package org.core.homework.hw6.animals;

public class Veterinarian {

    public void treatAnimal(Animal animal) {
        System.out.println("На приёме: food = " + animal.getFood() + ", location = " + animal.getLocation());
    }

    public void examine(Animal animal) {
        if (animal instanceof Dog dog) {
            System.out.println("Порода: " + dog.getBreed());
        } else if (animal instanceof Cat cat) {
            System.out.println("Домашняя: " + cat.isIndoor());
        } else if (animal instanceof Horse horse) {
            System.out.println("Максимальная скорость, км/ч: " + horse.getMaxSpeed());
        }
    }
}
