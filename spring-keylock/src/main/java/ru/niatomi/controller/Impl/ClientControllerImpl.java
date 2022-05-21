package ru.niatomi.controller.Impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.niatomi.controller.ClientController;
import ru.niatomi.entity.OpenerEntity;
import ru.niatomi.exceptions.OpenerAlreadyExistsException;
import ru.niatomi.service.ClientService;

/**
 * @author niatomi
 */
@AllArgsConstructor
public class ClientControllerImpl implements ClientController {

    private final ClientService clientService;

    public ResponseEntity<String> create(OpenerEntity openerEntity) {
        try {
            clientService.create(openerEntity);
            return ResponseEntity.ok("User saved");
        } catch (OpenerAlreadyExistsException e) {
            return ResponseEntity.badRequest().body("Error happened");
        }
    }

    @Override
    public ResponseEntity<String> deleteAccessor(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<String> update(OpenerEntity openerEntity, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Page<OpenerEntity>> getOpenersWithAccess(Integer page, Integer size) {
        return null;
    }

}
