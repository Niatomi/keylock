package ru.niatomi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author niatomi
 */
@Data
@AllArgsConstructor
public class PasswordWithOpenerIdDto {

    private Long openerId;
    private String type;
    private String value;

}
