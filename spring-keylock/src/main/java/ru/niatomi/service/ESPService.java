package ru.niatomi.service;

import org.springframework.stereotype.Service;
import ru.niatomi.model.dto.ActionsHistoryDto;
import ru.niatomi.model.dto.PasswordWithOpenerIdDto;

import java.util.List;

/**
 * @author niatomi
 */
@Service
public interface ESPService {

    List<PasswordWithOpenerIdDto> getPasswords();
    void addAction(ActionsHistoryDto actionsHistoryDto);
}
