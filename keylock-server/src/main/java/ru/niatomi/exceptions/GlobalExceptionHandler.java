package ru.niatomi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.niatomi.exceptions.exc.OpenerNotFoundException;
import ru.niatomi.exceptions.exc.ExceptionResponse;

import javax.validation.ConstraintViolationException;

/**
 * @author niatomi
 */
@RestControllerAdvice
public class GlobalExceptionHandler {


    // TODO: добавить сеттеры к новым параметрам респонса
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<ExceptionResponse> handleValidationException(ConstraintViolationException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage(ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler({OpenerNotFoundException.class})
    public ResponseEntity<ExceptionResponse> handleValidationException(OpenerNotFoundException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage(ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
