package org.core.homework.hw7;

public enum RobotHead {
    ANIMATRONIC_HEAD("анатомическая голова"),
    SENSOR_HEAD("сенсорная голова"),
    BIONIC_HEAD("бионическая голова");

    private final String title;

    RobotHead(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
