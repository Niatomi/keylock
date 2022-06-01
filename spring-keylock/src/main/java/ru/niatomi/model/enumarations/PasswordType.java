package ru.niatomi.model.enumarations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author niatomi
 */
@AllArgsConstructor
@Getter
public enum PasswordType {
    KEYPAD,
    RFID
}
