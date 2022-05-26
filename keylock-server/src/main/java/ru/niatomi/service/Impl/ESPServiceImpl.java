package ru.niatomi.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.niatomi.model.domain.ConfigurationEntity;
import ru.niatomi.model.domain.PasswordEntity;
import ru.niatomi.model.dto.ActionHistoryDto;
import ru.niatomi.model.dto.PasswordDto;
import ru.niatomi.model.dto.PasswordWithOpenerId;
import ru.niatomi.repository.PasswordRepository;
import ru.niatomi.service.ESPService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niatomi
 */
@Service
@AllArgsConstructor
public class ESPServiceImpl implements ESPService {

    private final PasswordRepository passwordRepository;

    @Override
    public List<PasswordWithOpenerId> getAllPasswords() {
        List<PasswordWithOpenerId> passwordList = new ArrayList<PasswordWithOpenerId>();

        passwordRepository.findAll().forEach(p -> passwordList.add(new PasswordWithOpenerId(p.getOpener().getId(), p.getType().toString().toLowerCase(), p.getValue())));
        return passwordList;
    }

    @Override
    public ConfigurationEntity getConfiguration() {
        return null;
    }

    @Override
    public void addActions(ActionHistoryDto actionHistoryDto) {

    }

    @Override
    public void addActionsWithOffline(ActionHistoryDto actionHistoryDto) {

    }

    @Override
    public void changeReadNewPasswordSetRequirement() {

    }
}
