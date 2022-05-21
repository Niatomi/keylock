package ru.niatomi.controller.Impl;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import ru.niatomi.controller.ESPController;
import ru.niatomi.model.dto.ActionsHistory;
import ru.niatomi.service.Impl.ESPServiceImpl;

/**
 * @author niatomi
 */
@AllArgsConstructor
public class ESPControllerImpl implements ESPController {

    private final ESPServiceImpl service;

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
