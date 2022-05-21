package ru.niatomi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.niatomi.model.ActionsHistory;

/**
 * @author niatomi
 */
@RestController
@RequestMapping("/esp")
public interface ESPController {

    @GetMapping
    ResponseEntity getPasswords();

    @PostMapping
    void addActions(@RequestBody ActionsHistory actionsHistory);
}
