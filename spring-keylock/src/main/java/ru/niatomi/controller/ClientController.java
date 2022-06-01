package ru.niatomi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.niatomi.model.domain.OpenerEntity;
import ru.niatomi.model.dto.OpenerDtoWithoutId;
import ru.niatomi.model.dto.PasswordDtoValueAndType;
import ru.niatomi.model.enumarations.PasswordType;

import java.util.List;

/**
 * @author niatomi
 */
@RestController
@RequestMapping("/client")
public interface ClientController {

    @PostMapping("/signUpOpener")
    @Operation(description = "Request for creating new opener.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.TEXT_PLAIN_VALUE)}),
    })
    ResponseEntity<String> signUpOpener(@RequestBody OpenerDtoWithoutId opener);

    @PatchMapping("/updateOpener")
    @Operation(description = "Request to update opener.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.TEXT_PLAIN_VALUE)}),
            @ApiResponse(responseCode = "400", description = "Trying to update first user")
    })
    ResponseEntity<String> updateOpener(@RequestBody OpenerEntity opener);

    @PutMapping("/addPasswordToOpener/{id}")
    @Operation(description = "Request for adding new password for opener.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.TEXT_PLAIN_VALUE)}),
            @ApiResponse(responseCode = "400", description = "Updating user might be with id=1"),
            @ApiResponse(responseCode = "400", description = "Updating user not found"),
            @ApiResponse(responseCode = "400", description = "Adding password is not unique")
    })
    ResponseEntity<String> addPassword(@RequestParam Long id,
                                       @RequestParam PasswordType passwordType,
                                       @RequestParam String value);

    @GetMapping("/getAllOpeners")
    @Operation(description = "Request for getting all openers.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
    })
    ResponseEntity<List<OpenerEntity>> getAllOpeners();

    @GetMapping("/getOpener/{id}")
    @Operation(description = "Request for getting one opener.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "400", description = "Opener not found")
    })
    ResponseEntity<OpenerEntity> getOpener(@PathVariable Long id);

    @GetMapping("/getOpenersWithAccess")
    @Operation(description = "Request getting in pages all openers, which have access.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
    })
    ResponseEntity<Page<OpenerEntity>> getOpenersWithPasswordInPages(@RequestParam(defaultValue = "0") Integer page,
                                                                     @RequestParam(defaultValue = "10") Integer size);
    @GetMapping("/getOpeners")
    @Operation(description = "Request for getting all openers in pages.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
    })
    ResponseEntity<Page<OpenerEntity>> getAllOpenersInPages(@RequestParam(defaultValue = "0") Integer page,
                                                            @RequestParam(defaultValue = "10") Integer size);

    @DeleteMapping("/deleteOpener")
    @Operation(description = "Request for deleting opener.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.TEXT_PLAIN_VALUE)}),
            @ApiResponse(responseCode = "400", description = "Opener not found")
    })
    ResponseEntity<String> deleteOpener(@RequestParam Long openerId);

    @DeleteMapping("/deleteAllPasswordFromOpener")
    @Operation(description = "Request for deleting all passwords of user.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.TEXT_PLAIN_VALUE)}),
            @ApiResponse(responseCode = "400", description = "Opener not found"),
            @ApiResponse(responseCode = "400", description = "Opener might be with id=1")
    })
    ResponseEntity<String> deleteOpenerPasswords(@RequestParam Long openerId);

    @PatchMapping("/openLock")
    @Operation(description = "Request for open access to keylock.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.TEXT_PLAIN_VALUE)}),
    })
    ResponseEntity<String> openKeylock();

    @PatchMapping("/blockLock")
    @Operation(description = "Request for blocking access to keylock.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.TEXT_PLAIN_VALUE)}),
    })
    ResponseEntity<String> blockKeylock();

}
