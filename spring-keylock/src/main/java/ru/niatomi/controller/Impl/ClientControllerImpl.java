package ru.niatomi.controller.Impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.niatomi.controller.ClientController;
import ru.niatomi.entity.KeylockConfig;
import ru.niatomi.entity.OpenerEntity;
import ru.niatomi.exceptions.OpenerAlreadyExistsException;
import ru.niatomi.service.ClientService;

import java.util.List;

/**
 * @author niatomi
 */
@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClientControllerImpl implements ClientController {

    private final ClientService clientService;

    @Override
    public ResponseEntity create(OpenerEntity openerEntity) {
        clientService.create(openerEntity);
        return ResponseEntity.ok("User saved");
    }

    @Override
    public ResponseEntity<String> updateUser() {
        return null;
    }

    @Override
    public ResponseEntity<List<OpenerEntity>> getAllUsers() {
        return null;
    }


}
