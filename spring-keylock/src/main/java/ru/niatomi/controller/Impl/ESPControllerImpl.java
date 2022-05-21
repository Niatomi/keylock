package ru.niatomi.controller.Impl;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.niatomi.controller.ESPController;
import ru.niatomi.model.dto.ActionsHistoryDto;
import ru.niatomi.service.Impl.ESPServiceImpl;

/**
 * @author niatomi
 */
@RestController
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

    public void addActions(ActionsHistoryDto actionsHistoryDto) {
        try {
            service.addAction(actionsHistoryDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
