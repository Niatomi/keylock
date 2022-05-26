package ru.niatomi.controller.Impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.niatomi.controller.MainUserController;
import ru.niatomi.model.domain.OpenerEntity;
import ru.niatomi.model.dto.OpenerDto;
import ru.niatomi.service.Impl.MainUserService;

import java.util.List;

/**
 * @author niatomi
 */
@RestController
@AllArgsConstructor
public class MainUserControllerImpl implements MainUserController {

    private final MainUserService service;

    @Override
    public ResponseEntity<String> signUp(OpenerEntity opener) {
        return ResponseEntity.ok(service.signUp(opener));
    }

    @Override
    public ResponseEntity<String> update(OpenerEntity opener) {
        return ResponseEntity.ok(service.update(opener));
    }

    @Override
    public ResponseEntity<List<OpenerEntity>> getAllOpeners() {
        return ResponseEntity.ok(service.getAllOpeners());
    }

    @Override
    public ResponseEntity<Page<OpenerEntity>> getByOpenersByPages(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(service.getByOpenersByPages(pageRequest));
    }

    @Override
    public ResponseEntity<OpenerDto> getOpener(Long id) {
        return null;
    }

    // TODO: и вот эту штуку обновить
    @Override
    public ResponseEntity<Page<OpenerEntity>> getOpenersWithAccess(Integer page, Integer size) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteOpener(Long id) {
        return ResponseEntity.ok(service.deleteOpener(id));
    }

}
