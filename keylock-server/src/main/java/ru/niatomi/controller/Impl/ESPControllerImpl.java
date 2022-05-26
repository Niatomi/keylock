package ru.niatomi.controller.Impl;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.niatomi.controller.ESPController;
import ru.niatomi.model.domain.ConfigurationEntity;
import ru.niatomi.model.domain.PasswordEntity;
import ru.niatomi.model.dto.ActionHistoryDto;
import ru.niatomi.model.dto.PasswordWithOpenerId;
import ru.niatomi.repository.PasswordRepository;
import ru.niatomi.service.ESPService;

import java.util.List;

/**
 * @author niatomi
 */
@RestController
@AllArgsConstructor
public class ESPControllerImpl implements ESPController {

    private final ESPService service;
    private final PasswordRepository passwordRepository;

    @Override
    public ResponseEntity<List<PasswordWithOpenerId>> getAllPasswords() {

        System.out.println(passwordRepository.findAll());
        return ResponseEntity.ok(service.getAllPasswords());
    }

    @Override
    public ResponseEntity<ConfigurationEntity> getConfiguration() {
        return ResponseEntity.ok(service.getConfiguration());
    }

    @Override
    public void addActions(ActionHistoryDto actionHistoryDto) {
        service.addActions(actionHistoryDto);
    }

    @Override
    public void addActionsWithOffline(ActionHistoryDto actionHistoryDto) {
        service.addActionsWithOffline(actionHistoryDto);
    }

    @Override
    public void changeReadNewPasswordSetRequirement() {
        service.changeReadNewPasswordSetRequirement();
    }
}
