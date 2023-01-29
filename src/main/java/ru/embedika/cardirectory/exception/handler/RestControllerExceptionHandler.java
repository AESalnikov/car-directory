package ru.embedika.cardirectory.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.embedika.cardirectory.pojo.ErrorMessage;
import ru.embedika.cardirectory.exception.CarAlreadyExistException;
import ru.embedika.cardirectory.exception.CarNotExistException;

@RestControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler(CarAlreadyExistException.class)
    public ResponseEntity<ErrorMessage> carAlreadyExistException(CarAlreadyExistException exception) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setCode(HttpStatus.CONFLICT.value());
        errorMessage.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CarNotExistException.class)
    public ResponseEntity<ErrorMessage> carNotExistException(CarNotExistException exception) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setCode(HttpStatus.NOT_FOUND.value());
        errorMessage.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> anyException(Exception exception) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorMessage.setMessage("Произошла непредвиденная ошибка: " + exception.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
