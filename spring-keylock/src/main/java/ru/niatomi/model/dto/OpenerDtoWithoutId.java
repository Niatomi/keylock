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
public class OpenerDtoWithoutId {

    private String firstName;
    private String secondName;
    private String thirdName;

}
