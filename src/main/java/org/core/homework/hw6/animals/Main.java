package org.core.homework.hw6.animals;

public class Main {

    public static void main(String[] args) {
        Animal[] animals = addAnimals();
        Veterinarian vet = new Veterinarian();

        printAnimals(animals, vet);
        getCounterAnimals(animals);
    }

    private static Animal[] addAnimals() {
        Animal[] animals = new Animal[6];
        animals[0] = new Dog("Мясо на кости", "Будка", "Овчарка");
        animals[1] = new Dog("Корм для собак", "Дом", "Сиба - Ину");
        animals[2] = new Cat("Влажный корм", "Квартира", true);
        animals[3] = new Cat("Мыши", "Квартира", false);
        animals[4] = new Horse("Сено", "Конюшня", 48);
        animals[5] = new Horse("Мюсли", "Люкс-конюшня", 65);
        return animals;
    }

    private static void printAnimals(Animal[] animals, Veterinarian vet) {
        int number = 1;
        for (Animal animal : animals) {
            System.out.println("=== Животное №" + number++ + " ===");
            animal.makeNoise();
            animal.eat();
            animal.sleep();
            vet.treatAnimal(animal);
            vet.examine(animal);
            System.out.println(animal.toString());
            System.out.println();
        }
    }

    private static void getCounterAnimals(Animal[] animals) {
        int dogCount = 0;
        int catCount = 0;
        int horseCount = 0;

        for (Animal animal : animals) {
            if (animal instanceof Dog dog) {
                dogCount++;
            } else if (animal instanceof Cat cat) {
                catCount++;
            } else if (animal instanceof Horse horse) {
                horseCount++;
            }
        }
        System.out.println("=== Итог ===");
        System.out.println("Собак: " + dogCount);
        System.out.println("Кошек: " + catCount);
        System.out.println("Лошадей: " + horseCount);
    }
}
