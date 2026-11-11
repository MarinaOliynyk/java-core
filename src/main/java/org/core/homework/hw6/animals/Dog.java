package org.core.homework.hw6.animals;

public class Dog extends Animal {

    private String breed;

    @Override
    public void makeNoise() {
        System.out.println("Собака лает: Гав-гав!");
    }

    @Override
    public void eat() {
        System.out.println("Собака ест " + getFood());
    }

    public Dog(String food, String location, String breed) {
        super(food, location);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food='" + getFood() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }
}
