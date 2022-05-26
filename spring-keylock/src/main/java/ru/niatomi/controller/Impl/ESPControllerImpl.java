package ru.niatomi.controller.Impl;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.niatomi.controller.ESPController;
import ru.niatomi.model.dto.ActionsHistoryDto;
import ru.niatomi.model.dto.PasswordWithOpenerIdDto;
import ru.niatomi.service.Impl.ESPServiceImpl;

import java.util.List;

/**
 * @author niatomi
 */
@RestController
@AllArgsConstructor
public class ESPControllerImpl implements ESPController {

    private final ESPServiceImpl service;

    public ResponseEntity<List<PasswordWithOpenerIdDto>> getPasswords() {
        return ResponseEntity.ok(service.getPasswords());
    }

    public void addActions(ActionsHistoryDto actionsHistoryDto) {
        try {
            service.addAction(actionsHistoryDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addActionsOfOffline(ActionsHistoryDto actionsHistoryDto) {

    }
}
