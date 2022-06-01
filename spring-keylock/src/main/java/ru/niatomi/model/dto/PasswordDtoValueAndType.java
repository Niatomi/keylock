package ru.niatomi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author niatomi
 */
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PasswordDtoValueAndType {

    private String type;
    private String value;

}
