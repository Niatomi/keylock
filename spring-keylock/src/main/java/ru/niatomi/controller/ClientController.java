package ru.niatomi.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.niatomi.entity.OpenerEntity;

import java.awt.print.Pageable;

/**
 * @author niatomi
 */
@RestController
@RequestMapping("/client")
public interface ClientController {

    @PostMapping("/create")
    ResponseEntity<String> create(@RequestBody OpenerEntity openerEntity);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteAccessor(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<String> update(@RequestBody OpenerEntity openerEntity, @PathVariable Long id);

    @GetMapping("/openersWithAccess/{page}")
    ResponseEntity<Page<OpenerEntity>> getOpenersWithAccess(@PathVariable Integer page,
                                                            @RequestParam(defaultValue = "10") Integer size);
}
