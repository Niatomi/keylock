package ru.niatomi.controller.Impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.niatomi.controller.ESPController;
import ru.niatomi.model.ActionsHistory;
import ru.niatomi.service.ESPService;

/**
 * @author niatomi
 */
@AllArgsConstructor
public class ESPControllerImpl implements ESPController {

    private final ESPService service;

    public ResponseEntity getPasswords() {
        try {
            return ResponseEntity.ok(service.getPasswords());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error happened");
        }
    }

    public void addActions(ActionsHistory actionsHistory) {
        try {
            service.addAction(actionsHistory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
