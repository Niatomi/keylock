package ru.niatomi.controller.Impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.niatomi.controller.ClientController;
import ru.niatomi.controller.ESPController;
import ru.niatomi.model.domain.OpenerEntity;
import ru.niatomi.model.domain.PasswordEntity;
import ru.niatomi.model.dto.OpenerDtoWithoutId;
import ru.niatomi.model.dto.PasswordDtoValueAndType;
import ru.niatomi.model.enumarations.PasswordType;
import ru.niatomi.repository.OpenerRepository;
import ru.niatomi.repository.PasswordRepository;
import ru.niatomi.service.ClientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author niatomi
 */
@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClientControllerImpl implements ClientController {

    private ClientService service;

    @Override
    public ResponseEntity<String> signUpOpener(OpenerDtoWithoutId opener) {
        return ResponseEntity.ok(service.signUpOpener(opener));
    }

    @Override
    public ResponseEntity<String> updateOpener(OpenerEntity opener) {
        return ResponseEntity.ok(service.updateOpener(opener));
    }

    @Override
    public ResponseEntity<String> addPassword(Long id,
                                              PasswordType passwordType,
                                              String passwordValue) {
        return ResponseEntity.ok(service.addPassword(id, passwordType, passwordValue));
    }

    @Override
    public ResponseEntity<List<OpenerEntity>> getAllOpeners() {
        return ResponseEntity.ok(service.getAllOpeners());
    }

    @Override
    public ResponseEntity<OpenerEntity> getOpener(Long id) {
        return ResponseEntity.ok(service.getOpener(id));
    }

    @Override
    public ResponseEntity<Page<OpenerEntity>> getOpenersWithPasswordInPages(Integer page, Integer size) {
        return ResponseEntity.ok(service.getOpenersWithPasswordInPages(page, size));
    }

    @Override
    public ResponseEntity<Page<OpenerEntity>> getAllOpenersInPages(Integer page, Integer size) {
        return ResponseEntity.ok(service.getOpenersWithPasswordInPages(page, size));
    }

    @Override
    public ResponseEntity<String> deleteOpener(Long openerId) {
        return ResponseEntity.ok(service.deleteOpener(openerId));
    }

    @Override
    public ResponseEntity<String> deleteOpenerPasswords(Long openerId) {
        return ResponseEntity.ok(service.deleteOpenerPasswords(openerId));
    }

    @Override
    public ResponseEntity<String> openKeylock() {
        return ResponseEntity.ok(service.openKeylock());
    }

    @Override
    public ResponseEntity<String> blockKeylock() {
        return ResponseEntity.ok(service.blockKeylock());
    }

}
