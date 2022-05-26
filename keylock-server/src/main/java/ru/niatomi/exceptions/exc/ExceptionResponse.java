package ru.niatomi.exceptions.exc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

/**
 * @author niatomi
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExceptionResponse {

    private HttpStatus status;
    private String message;
    private LocalDate date = LocalDate.now();

}
