package org.core.homework.hw7;

public enum RobotBody {
    ANIMATRONIC_BODY("анатомическое тело"),
    SENSOR_BODY("сенсорное тело"),
    BIONIC_BODY("бионическое тело");

    private final String title;

    RobotBody(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
