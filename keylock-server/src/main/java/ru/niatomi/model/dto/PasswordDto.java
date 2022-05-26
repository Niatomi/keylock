package ru.niatomi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author niatomi
 */
@Data
@AllArgsConstructor
public class PasswordDto {
    private String type;
    private String value;

}
