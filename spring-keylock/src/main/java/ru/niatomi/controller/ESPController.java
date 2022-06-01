package ru.niatomi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.niatomi.dto.KeylockConfigDto;
import ru.niatomi.model.dto.ActionsHistoryDto;
import ru.niatomi.model.dto.PasswordWithOpenerIdDto;
import ru.niatomi.service.ESPService;

import java.util.List;

/**
 * @author niatomi
 */
@RestController
@RequestMapping("/esp")
public interface ESPController {

    @GetMapping
    public ResponseEntity<List<PasswordWithOpenerIdDto>> getPasswords();

    @PostMapping
    void addActions(@RequestBody ActionsHistoryDto actionsHistory);

    @GetMapping("/getConfig")
    ResponseEntity<KeylockConfigDto> getConfig();

    void setLock();
}
