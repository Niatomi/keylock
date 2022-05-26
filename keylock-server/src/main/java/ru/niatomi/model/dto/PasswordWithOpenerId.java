package ru.niatomi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.SecondaryTable;

/**
 * @author niatomi
 */
@Data
@AllArgsConstructor
public class PasswordWithOpenerId {

    private Long openerId;
    private String type;
    private String value;

}
