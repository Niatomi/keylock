package ru.niatomi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.niatomi.model.domain.ConfigurationEntity;
import ru.niatomi.model.domain.PasswordEntity;
import ru.niatomi.model.dto.ActionHistoryDto;
import ru.niatomi.model.dto.PasswordWithOpenerId;

import java.util.List;

/**
 * @author niatomi
 */
@Service
public interface ESPService {

    List<PasswordWithOpenerId> getAllPasswords();

    ConfigurationEntity getConfiguration();

    void addActions(ActionHistoryDto actionHistoryDto);

    void addActionsWithOffline(ActionHistoryDto actionHistoryDto);

    void changeReadNewPasswordSetRequirement();
}
