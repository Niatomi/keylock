package ru.niatomi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.niatomi.model.ActionsHistory;

/**
 * @author niatomi
 */
@RestController
@RequestMapping("/esp")
public interface ESPController {

    @GetMapping

    @Operation(description = "Request from ESP for get all passwords with opener containing the password.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
    })
    ResponseEntity getPasswords();

    @PostMapping
    @Operation(description = "Save action with keylock in DB.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
    })
    void addActions(@RequestBody ActionsHistory actionsHistory);
}
