package ru.niatomi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.niatomi.model.domain.PasswordEntity;

import java.time.LocalDate;
import java.util.List;

/**
 * @author niatomi
 */
@Data
@AllArgsConstructor
public class OpenerDto {

    private Long id;
    private PasswordDto passwordDto;
    private String firstName;
    private String secondName;
    private String thirdName;
    private List<PasswordDto> passwords;
    private LocalDate signUpDate;
    private LocalDate deleteDate;

}
