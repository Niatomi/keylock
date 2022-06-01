package ru.niatomi.controller.Impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.niatomi.controller.ESPController;
import ru.niatomi.dto.KeylockConfigDto;
import ru.niatomi.model.dto.ActionsHistoryDto;
import ru.niatomi.model.dto.PasswordWithOpenerIdDto;
import ru.niatomi.service.ESPService;

import java.util.List;

/**
 * @author niatomi
 */
@RestController
@AllArgsConstructor
public class ESPControllerImpl implements ESPController {

    private final ESPService service;

    @Override
    public ResponseEntity<List<PasswordWithOpenerIdDto>> getPasswords() {
        return ResponseEntity.ok(service.getPasswords());
    }

    @Override
    public void addActions(@RequestBody ActionsHistoryDto actionsHistory) {
        service.addAction(actionsHistory);
    }

    @Override
    public ResponseEntity<KeylockConfigDto> getConfig() {
        return ResponseEntity.ok(service.getConfig());
    }

    @Override
    public void setLock() {
        service.lockConfig();
    }

}
