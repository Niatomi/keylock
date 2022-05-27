package ru.niatomi.controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.niatomi.controller.ESPController;
import ru.niatomi.dto.KeylockConfigDto;
import ru.niatomi.model.ActionsHistory;
import ru.niatomi.service.ESPService;

/**
 * @author niatomi
 */
@RestController
@RequestMapping("/esp")
public class ESPControllerImpl implements ESPController {

    @Autowired
    ESPService service;

    @Override
    public ResponseEntity getPasswords() {
        try {
            return ResponseEntity.ok(service.getPasswords());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened");
        }
    }

    @Override
    public void addActions(ActionsHistory actionsHistory) {
        try {
            service.addAction(actionsHistory);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
