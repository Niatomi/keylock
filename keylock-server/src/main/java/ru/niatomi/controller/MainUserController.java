package ru.niatomi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.niatomi.model.domain.OpenerEntity;
import ru.niatomi.model.dto.OpenerDto;

import java.util.List;

/**
 * @author niatomi
 */
@RequestMapping("/clientController")
public interface MainUserController {

    @PostMapping("/signUp")
    @Operation(description = "Регистрация пользователя")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.TEXT_PLAIN_VALUE)}),
            @ApiResponse(responseCode = "406", description = "Validation failed")
    })
    ResponseEntity<String> signUp(@RequestBody OpenerEntity opener);

    @PutMapping("/update")
    @Operation(description = "Изменение атрибутов клиента")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.TEXT_PLAIN_VALUE)}),
            @ApiResponse(responseCode = "400", description = "User already exists"),
            @ApiResponse(responseCode = "406", description = "Validation failed")
    })
    ResponseEntity<String> update(@RequestBody OpenerEntity opener);

    @GetMapping("/getAllOpeners")
    @Operation(description = "Предоставление информации полным списком всех зарегистрированных пользователей")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
    })
    ResponseEntity<List<OpenerEntity>> getAllOpeners();

    @GetMapping("/getOpenersByPage/{page}")
    @Operation(description = "Предоставление информации о всех зарегистрированных пользователях с постраничным представлением данных")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
    })
    ResponseEntity<Page<OpenerEntity>> getByOpenersByPages(@PathVariable Integer page,
                                                           @RequestParam(defaultValue = "10") Integer size);

    @GetMapping("/getOpener/{id}")
    @Operation(description = "Предоставление информации об одном пользователе по уникальному идентификатору")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "400", description = "Client not found")
    })
    ResponseEntity<OpenerDto> getOpener(@PathVariable Long id);

    @GetMapping("/getOpenersWithAccess/{page}")
    @Operation(description = "Предоставление списка пользователей, имеющих пароли, с постраничным представлением данных")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
    })
    ResponseEntity<Page<OpenerEntity>> getOpenersWithAccess(@PathVariable Integer page,
                                                            @RequestParam(defaultValue = "10") Integer size);

    @DeleteMapping("/deleteOpener/{id}")
    @Operation(description = "Предоставление списка пользователей, имеющих пароли, с постраничным представлением данных")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.TEXT_PLAIN_VALUE)}),
            @ApiResponse(responseCode = "400", description = "Client not found")
    })
    ResponseEntity<String> deleteOpener(@PathVariable Long id);
}
