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

import java.util.List;

/**
 * @author niatomi
 */
@RestController
@RequestMapping("/client")
public interface ClientController {

    @PostMapping("/create")
    @Operation(description = "Request for creating new opener.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.TEXT_PLAIN_VALUE)}),
            @ApiResponse(responseCode = "400", description = "User already exists"),
            @ApiResponse(responseCode = "406", description = "Validation failed")
    })
    ResponseEntity<String> create(@RequestBody OpenerEntity openerEntity);

    @DeleteMapping("/delete/{id}")
    @Operation(description = "Request for delete opener by id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.TEXT_PLAIN_VALUE)}),
            @ApiResponse(responseCode = "400", description = "Client not found")
    })
    ResponseEntity<String> deleteAccessor(@PathVariable Long id);

    @PutMapping("/{id}")
    @Operation(description = "Request for update opener by id .")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.TEXT_PLAIN_VALUE)}),
            @ApiResponse(responseCode = "400", description = "User already exists"),
            @ApiResponse(responseCode = "406", description = "Validation failed")
    })
    ResponseEntity<String> update(@RequestBody OpenerEntity openerEntity, @PathVariable Long id);

    @GetMapping("/openersWithAccess/{page}")
    @Operation(description = "Request for get in pages all of the openers.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
    })
    ResponseEntity<Page<OpenerEntity>> getOpenersWithAccess(@PathVariable Integer page,
                                                            @RequestParam(defaultValue = "10") Integer size);

    @GetMapping("/openers")
    @Operation(description = "Request for get all of the openers.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
    })
    ResponseEntity<List<OpenerEntity>> getOpeners();
}
