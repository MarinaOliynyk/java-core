package org.core.homework.hw6.animals;

public class Horse extends Animal {

    private int maxSpeed;

    @Override
    public void makeNoise() {
        System.out.println("Лошадь ржёт: И-го-го!");
    }

    @Override
    public void eat() {
        System.out.println("Лошадь ест " + getFood());
    }

    public Horse(String food, String location, int maxSpeed) {
        super(food, location);
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Horse{" +
                "food='" + getFood() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", maxSpeed='" + maxSpeed + '\'' +
                '}';
    }
}
