package ru.niatomi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.niatomi.model.domain.PasswordEntity;

import javax.persistence.*;
import java.util.List;

/**
 * @author niatomi
 */
@AllArgsConstructor
@Getter
@Setter
public class OpenerDto {
    private Long id;

    private String firstName;
    private String secondName;
    private String thirdName;

    List<PasswordEntity> passwords;
}
