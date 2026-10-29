package org.core.homework.hw6.animals;

public class Cat extends Animal {

    private boolean isIndoor;

    @Override
    public void makeNoise() {
        System.out.println("Кошка мяукает: Мяу!");
    }

    @Override
    public void eat() {
        System.out.println("Кошка ест " + getFood());
    }

    public Cat(String food, String location, boolean isIndoor) {
        super(food, location);
        this.isIndoor = isIndoor;
    }

    public boolean isIndoor() {
        return isIndoor;
    }

    public void setIndoor(boolean indoor) {
        isIndoor = indoor;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "food='" + getFood() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", isIndoor='" + isIndoor + '\'' +
                '}';
    }
}
