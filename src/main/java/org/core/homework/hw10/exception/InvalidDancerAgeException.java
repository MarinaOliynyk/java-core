package org.core.homework.hw10.exception;

import lombok.Getter;
import lombok.Setter;

public class InvalidDancerAgeException extends Exception {

    @Getter
    @Setter
    private int invalidAge;

    public InvalidDancerAgeException(String message, int invalidAge) {
        super(message);
        this.invalidAge = invalidAge;
    }
}
