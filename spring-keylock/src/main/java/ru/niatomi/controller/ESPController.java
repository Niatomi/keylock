package ru.niatomi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.niatomi.dto.KeylockConfigDto;
import ru.niatomi.model.ActionsHistory;
import ru.niatomi.service.ESPService;

/**
 * @author niatomi
 */
@RestController
@RequestMapping("/esp")
public interface ESPController {

    @GetMapping
    public ResponseEntity getPasswords();

    @PostMapping
    void addActions(@RequestBody ActionsHistory actionsHistory);

    @GetMapping("/getConfig")
    ResponseEntity<KeylockConfigDto> getConfig();

    void setLock();
}
