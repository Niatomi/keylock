package ru.niatomi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author niatomi
 */
@AllArgsConstructor
@Data
public class KeylockConfigDto {
    private boolean sound;
    private boolean showPassword;
    private boolean re_read_password;
    private boolean lock;
}
