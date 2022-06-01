package ru.niatomi.exceptions.excep;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * @author niatomi
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    LocalDateTime dateStamp;
    HttpStatus status;
    String message;
}
