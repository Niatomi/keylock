package ru.niatomi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.niatomi.entity.OpenerEntity;
import ru.niatomi.exceptions.OpenerAlreadyExistsException;
import ru.niatomi.service.ClientService;

import java.util.List;

/**
 * @author niatomi
 */
@RestController
@RequestMapping("/client")
public interface ClientController {

    @PostMapping("/create")
    ResponseEntity<String> create(@RequestBody OpenerEntity openerEntity);

    @PostMapping("/update")
    ResponseEntity<String> updateUser();

    @GetMapping("/getAllUsers")
    ResponseEntity<List<OpenerEntity>> getAllUsers();



}
