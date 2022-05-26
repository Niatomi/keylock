package ru.niatomi.controller.Impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.niatomi.controller.ClientController;
import ru.niatomi.model.domain.OpenerEntity;
import ru.niatomi.service.Impl.ClientServiceImpl;

import java.util.List;

/**
 * @author niatomi
 */
@RestController
@AllArgsConstructor
public class ClientControllerImpl implements ClientController {

    private final ClientServiceImpl service;

    public ResponseEntity<String> create(OpenerEntity openerEntity) {
        service.create(openerEntity);
        return ResponseEntity.ok("User saved");
    }

    @Override
    public ResponseEntity<String> deleteAccessor(Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @Override
    public ResponseEntity<String> update(OpenerEntity openerEntity) {
//        return ResponseEntity.update;
        return null;
    }


    @Override
    public ResponseEntity<Page<OpenerEntity>> getOpenersWithAccess(Integer page, Integer size) {
        return null;
    }

    @Override
    public ResponseEntity<List<OpenerEntity>> getOpeners() {
        return null;
    }

}
