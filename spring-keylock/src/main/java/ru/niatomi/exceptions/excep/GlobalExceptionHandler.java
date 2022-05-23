package ru.niatomi.exceptions.excep;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.niatomi.exceptions.OpenerAlreadyExistsException;

import javax.validation.ConstraintViolationException;

/**
 * @author niatomi
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OpenerAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleValidExceptions(OpenerAlreadyExistsException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setException(ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<ExceptionResponse> handleValidationException(ConstraintViolationException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setException(ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
    }

}
