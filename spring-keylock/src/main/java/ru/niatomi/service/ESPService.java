package ru.niatomi.service;

import ru.niatomi.dto.KeylockConfigDto;
import ru.niatomi.model.domain.ActionsHistoryEntity;
import ru.niatomi.model.domain.KeylockConfig;
import ru.niatomi.model.dto.ActionsHistoryDto;
import ru.niatomi.model.dto.PasswordWithOpenerIdDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author niatomi
 */
public interface ESPService {

    public List<PasswordWithOpenerIdDto> getPasswords();

    public void addAction(ActionsHistoryDto actionsHistory);

    public KeylockConfigDto getConfig();

    public void lockConfig();

}
