package ru.niatomi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.niatomi.model.domain.ConfigurationEntity;
import ru.niatomi.model.domain.PasswordEntity;
import ru.niatomi.model.dto.ActionHistoryDto;
import ru.niatomi.model.dto.PasswordWithOpenerId;

import java.util.List;

/**
 * @author niatomi
 */
@RequestMapping("/esp")
public interface ESPController {

    @GetMapping
    ResponseEntity<List<PasswordWithOpenerId>> getAllPasswords();

    @GetMapping("/getConfiguration")
    ResponseEntity<ConfigurationEntity> getConfiguration();

    @PostMapping
    @Operation(description = "Save action with keylock in DB.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
    })
    void addActions(@RequestBody ActionHistoryDto actionHistoryDto);

    @PostMapping("/registerOfflineHistory")
    @Operation(description = "Save offline actions with keylock in DB.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
    })
    void addActionsWithOffline(@RequestBody ActionHistoryDto actionHistoryDto);

    @PostMapping("/changeReReadParametr")
    @Operation(description = "Changes parametr on refresh passwords.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
    })
    void changeReadNewPasswordSetRequirement();

}
