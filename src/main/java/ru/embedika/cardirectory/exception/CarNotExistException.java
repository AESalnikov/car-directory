package ru.embedika.cardirectory.exception;

public class CarNotExistException extends RuntimeException {

    public CarNotExistException(String message) {
        super(message);
    }

}
