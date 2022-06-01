package ru.niatomi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.niatomi.dto.KeylockConfigDto;
import ru.niatomi.model.dto.ActionsHistoryDto;
import ru.niatomi.model.dto.PasswordWithOpenerIdDto;

import java.util.List;

/**
 * @author niatomi
 */
@RestController
@RequestMapping("/esp")
public interface ESPController {

    @GetMapping
    @Operation(description = "Request for getting all available passwords.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
    })
    public ResponseEntity<List<PasswordWithOpenerIdDto>> getPasswords();

    @PostMapping
    @Operation(description = "Request for writing new action into history.")
    void addActions(@RequestBody ActionsHistoryDto actionsHistory);

    @GetMapping("/getConfig")
    @Operation(description = "Request for getting configuration of keylock.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
    })
    ResponseEntity<KeylockConfigDto> getConfig();

    @PostMapping("/setLock")
    @Operation(description = "Request from keylock to keep blocking condition in data base.")
    void setLock();
}
